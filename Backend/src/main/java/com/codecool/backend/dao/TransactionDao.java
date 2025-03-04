package com.codecool.backend.dao;

import com.codecool.backend.dao.model.Transaction;

public interface TransactionDao {
    int addTransaction(Transaction transaction);

    Transaction getTransactionById(int id);

    boolean updateTransaction(Transaction transaction);

    boolean deleteTransaction(int id);

    int getSumOfTransactionByCategoryId(int categoryId);

    int getAvrgSpendingByCategoryId(int categoryId);
}
