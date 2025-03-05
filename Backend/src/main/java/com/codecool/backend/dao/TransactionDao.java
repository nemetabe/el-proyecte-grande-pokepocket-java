package com.codecool.backend.dao;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import com.codecool.backend.dao.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDao {
    int createTransaction(NewTransactionDto transaction);

    List<Transaction> getAllTransactions() throws SQLException;

    Transaction getTransactionById(int id);

    boolean updateTransaction(Transaction transaction);

    boolean deleteTransaction(int id);

    int getSumOfTransactionByCategoryId(int categoryId);

    int getAvrgSpendingByCategoryId(int categoryId);
}
