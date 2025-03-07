package com.codecool.backend.service;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import com.codecool.backend.dao.TransactionDao;
import com.codecool.backend.dao.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionDao transactionDao;

    @Autowired
    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public List<TransactionDto> getAllTransactions() throws Exception {
        List<Transaction> allTransactions = transactionDao.getAllTransactions();
        List<TransactionDto> transactionDtos = new ArrayList<>();
        allTransactions.forEach(transaction -> transactionDtos.add(new TransactionDto(transaction)));
        return transactionDtos;
    }

    public int createTransaction(NewTransactionDto transaction) {
        return transactionDao.createTransaction(transaction);
    }

    public TransactionDto getTransactionById(int id) {
        Transaction transaction = transactionDao.getTransactionById(id);
        if (transaction == null) throw new IllegalArgumentException();
        return new TransactionDto(transaction);
    }

    public boolean updateTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction(transactionDto);
        return transactionDao.updateTransaction(transaction);
    }

    public boolean deleteTransaction(int id) {
        return transactionDao.deleteTransaction(id);
    }

    public int getSumOfTransactionByCategoryId(int categoryId) {
        return transactionDao.getSumOfTransactionByCategoryId(categoryId);
    }

    public int getAvrgSpendingByCategoryId(int categoryId) {
        return transactionDao.getAvrgSpendingByCategoryId(categoryId);
    }

}