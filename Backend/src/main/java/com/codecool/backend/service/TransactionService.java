package com.codecool.backend.service;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import com.codecool.backend.model.Transaction;
import com.codecool.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDto> getAllTransactions() throws Exception {
        List<Transaction> allTransactions = transactionRepository.findAll();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        allTransactions.forEach(transaction -> transactionDtos.add(new TransactionDto(transaction)));
        return transactionDtos;
    }

    public int createTransaction(NewTransactionDto transactionDto) {
        Transaction transaction = new Transaction(transactionDto);
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