package com.codecool.backend.dao;

import com.codecool.backend.controller.dto.NewTransactionDto;

public interface TransactionDao {
    int addTransaction(NewTransactionDto newTransactionDto);

    boolean updateTransaction(int id);

    boolean deleteTransaction(int id);

    int getSumOfTransactionByCategoryId(int categoryId);

    int getAvrgSpendingByCategoryId(int categoryId);
}
