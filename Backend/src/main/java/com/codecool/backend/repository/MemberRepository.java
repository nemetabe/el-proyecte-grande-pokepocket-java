package com.codecool.backend.repository;

import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean deleteMemberById(int id);

    Member getMemberById(int id);

    Member getMemberByEmailAndPassword(String email, String password);
}
