package com.codecool.backend.service;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import com.codecool.backend.model.Category;
import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;
import com.codecool.backend.repository.CategoryRepository;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final CategoryRepository categoryRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, MemberRepository memberRepository, MemberService memberService, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.memberRepository = memberRepository;
        this.memberService = memberService;
        this.categoryRepository = categoryRepository;
    }

    public List<TransactionDto> getAllTransactions() throws Exception {
        List<Transaction> allTransactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        allTransactions.forEach(transaction -> transactionDtos.add(new TransactionDto(transaction)));
        return transactionDtos;
    }

    public Long createTransaction(NewTransactionDto transactionDto) {
        Member member = memberRepository.getMemberById(transactionDto.memberId());
        Category category = categoryRepository.getCategoryById(transactionDto.categoryId());
        Transaction transaction = new Transaction(transactionDto);
        transaction.setMember(member);
        return transactionRepository.save(transaction).getId();
    }

    public TransactionDto getTransactionById(int id) {
        Transaction transaction = transactionRepository.getTransactionsById(id);
        if (transaction == null) throw new IllegalArgumentException();
        return new TransactionDto(transaction);
    }

    public boolean updateTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction(transactionDto);
        return transactionRepository.save(transaction) != null;
    }

    public boolean deleteTransaction(int id) {
        return transactionRepository.deleteTransactionById(id);
    }

    public int getSumOfTransactionByCategoryId(int categoryId) {
        return transactionRepository.getAllByCategoryId(categoryId)
                .stream()
                .mapToInt(Transaction::getAmount)
                .sum();
    }

    public OptionalDouble getAvrgSpendingByCategoryId(int categoryId) {
        return transactionRepository.getAllByCategoryId(categoryId)
                .stream()
                .mapToInt(Transaction::getAmount)
                .average();
    }

}