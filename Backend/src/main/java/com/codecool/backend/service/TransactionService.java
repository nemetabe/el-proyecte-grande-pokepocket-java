package com.codecool.backend.service;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.dao.TransactionDao;

public class TransactionService {
  private final TransactionDao transactionDao;

  public TransactionService(TransactionDao transactionDao) {
    this.transactionDao = transactionDao;
  }

  public int createTransaction(NewTransactionDto newTransactionDto) {
      return transactionDao.addTransaction(newTransactionDto);
  }

  public boolean updateTransaction(int id) {
      return transactionDao.updateTransaction(id);
  }

  public boolean deleteTransaction(int id) {
      return transactionDao.deleteTransaction(id);
  }

  public int getSumOfTransactionByCategoryId(int categoryId) {
    return 0;
  }

  public int getAvrgSpendingByCategoryId(int categoryId) {
    return 0;
  }

}