package com.codecool.backend.service;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.dao.TransactionDao;
import com.codecool.backend.dao.model.Transaction;

public class TransactionService {
  private final TransactionDao transactionDao;

  public TransactionService(TransactionDao transactionDao) {
    this.transactionDao = transactionDao;
  }

  public int createTransaction(Transaction transaction) {
      return transactionDao.addTransaction(transaction);
  }

  public boolean updateTransaction(Transaction transaction) {
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