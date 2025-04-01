package com.codecool.backend.repository;

import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public Optional<Transaction> getTransactionsById(int id);

    public boolean deleteTransactionById(int id);

    Optional<List<Transaction>> getAllByCategoryId(int categoryId);

    Optional<List<Transaction>> getAllByMemberAndDateAfter(Member member, LocalDate startDate);

    Optional<List<Transaction>> getAllByMember(Member member);
}
