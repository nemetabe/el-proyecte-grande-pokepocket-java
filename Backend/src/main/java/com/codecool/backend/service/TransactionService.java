package com.codecool.backend.service;

import com.codecool.backend.controller.dto.CategoryDto;
import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import com.codecool.backend.controller.exception.CategoryNotFoundException;
import com.codecool.backend.controller.exception.MemberNotFoundException;
import com.codecool.backend.controller.exception.TransactionNotFoundException;
import com.codecool.backend.model.Category;
import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;
import com.codecool.backend.repository.CategoryRepository;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::new)
                .toList();
    }

    public List<TransactionDto> getAllTransactions() {
        List<Transaction> allTransactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        allTransactions.forEach(transaction -> transactionDtos.add(new TransactionDto(transaction)));
        return transactionDtos;
    }

    public List<TransactionDto> getAllByUser(String email, LocalDate startDate) {

        Member member = memberRepository.findMemberByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        List<Transaction> transactions = new ArrayList<>();
        if(startDate == null){
            transactions = transactionRepository.getAllByMember(member)
                    .orElseThrow(TransactionNotFoundException::new);
        } else {
            transactions = transactionRepository.getAllByMemberAndDateAfter(member, startDate)
                .orElseThrow(TransactionNotFoundException::new);
        }
        return transactions.stream()
                .map(TransactionDto::new)
                .toList();
    }

    public Long createTransaction(String email,NewTransactionDto transactionDto) {
        Member member = memberRepository.findMemberByEmail(email)
                .orElseThrow(MemberNotFoundException::new);

        Category category = categoryRepository.getCategoryById(transactionDto.categoryId())
                .orElseThrow(CategoryNotFoundException::new);
        LocalDate date = LocalDate.now();
        Transaction transaction = new Transaction(transactionDto);
        transaction.setMember(member);
        transaction.setCategory(category);
        transaction.setDate(date);
        return transactionRepository.save(transaction).getId();
    }

    public TransactionDto getTransactionById(int id) {
        Transaction transaction = transactionRepository.getTransactionsById(id)
                .orElseThrow(TransactionNotFoundException::new);

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
        List<Transaction> transactions = transactionRepository.getAllByCategoryId(categoryId)
                .orElseThrow(TransactionNotFoundException::new);
        return transactions.stream()
                .mapToInt(Transaction::getAmount)
                .sum();
    }

    public OptionalDouble getAvgSpendingByCategoryId(int categoryId) {
        List<Transaction> transactions = transactionRepository.getAllByCategoryId(categoryId)
                .orElseThrow(TransactionNotFoundException::new);
        return transactions.stream()
                .mapToInt(Transaction::getAmount)
                .average();
    }

}