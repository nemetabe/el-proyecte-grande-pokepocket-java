package com.codecool.backend.dao;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.dao.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MemoryTransactionDao implements TransactionDao {

    Set<Transaction> transactions;

    public MemoryTransactionDao() {
        transactions = new HashSet<>();
    }

    @Override
    public int addTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction.id();
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactions.stream()
                .filter(transaction -> transaction.id() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateTransaction(Transaction transaction) {
        Transaction oldTransaction = getTransactionById(transaction.id());
        if (oldTransaction == null) {
            return false;
        }
        transactions.remove(oldTransaction);
        transactions.add(transaction);
        return true;
    }

        @Override
        public boolean deleteTransaction (int id){
            return transactions.remove(getTransactionById(id));
        }

        @Override
        public int getSumOfTransactionByCategoryId (int categoryId){
            return transactions.stream()
                    .filter(transaction -> transaction.categoryId() == categoryId)
                    .mapToInt(Transaction::amount)
                    .sum();
        }

        @Override
        public int getAvrgSpendingByCategoryId (int categoryId){
            return (int) transactions.stream()
                    .filter(transaction -> transaction.categoryId() == categoryId)
                    .mapToInt(Transaction::amount)
                    .average()
                    .orElse(0);
        }


}

