package com.codecool.backend.repository;

import com.codecool.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction getTransactionsById(int id);

    boolean deleteTransactionById(int id);

    List<Transaction> getAllByCategoryId(int categoryId);
}
