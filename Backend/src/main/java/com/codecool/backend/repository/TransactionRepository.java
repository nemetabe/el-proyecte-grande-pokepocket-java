package com.codecool.backend.repository;

import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public Optional<Transaction> getTransactionsById(int id);

    public boolean deleteTransactionById(int id);


    public Optional<List<Transaction>> getAllByCategoryId(int categoryId);

    List<Transaction> getAllByCategoryId(int categoryId);

    List<Transaction> getAllByMember(Member member);
}
