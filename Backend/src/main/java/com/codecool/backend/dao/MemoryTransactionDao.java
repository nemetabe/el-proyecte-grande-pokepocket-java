package com.codecool.backend.dao;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.dao.model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MemoryTransactionDao implements TransactionDao {

    Set<Transaction> transactions;

    public MemoryTransactionDao() {
        transactions = new HashSet<>();
    }

    @Override
    public int createTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction.getId();
    }

    @Override
    public List<Transaction> getAllTransactions() throws SQLException {
        return List.of();
    }

    @Override
    public Transaction getTransactionById(int id) {
        return transactions.stream()
                .filter(transaction -> transaction.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateTransaction(Transaction transaction) {
        Transaction oldTransaction = getTransactionById(transaction.getId());
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
                    .filter(transaction -> transaction.getCategoryId() == categoryId)
                    .mapToInt(Transaction::getAmount)
                    .sum();
        }

        @Override
        public int getAvrgSpendingByCategoryId (int categoryId){
            return (int) transactions.stream()
                    .filter(transaction -> transaction.getCategoryId() == categoryId)
                    .mapToInt(Transaction::getAmount)
                    .average()
                    .orElse(0);
        }


}

