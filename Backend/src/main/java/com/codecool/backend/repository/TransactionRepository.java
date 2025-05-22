package com.codecool.backend.repository;

import com.codecool.backend.model.transaction.Category;
import com.codecool.backend.model.user.Member;
import com.codecool.backend.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<List<Transaction>> getTransactionsByCategory(Category category);

    Optional<Transaction> getTransactionById(int id);

    boolean deleteTransactionById(int id);

    Optional<List<Transaction>> getAllByCategoryId(int categoryId);

    Optional<List<Transaction>> getAllByMemberAndDateAfter(Member member, LocalDate startDate);

    Optional<List<Transaction>> getAllByMember(Member member);
}
