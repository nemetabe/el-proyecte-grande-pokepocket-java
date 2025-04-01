package com.codecool.backend.repository;

import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public boolean deleteMemberById(int id);

    public Optional<Member> getMemberById(int id);

    public Optional<Member> getMemberByEmailAndPassword(String email, String password);

    Optional<Member> findMemberByName(String username);

    Optional<Member> findMemberByEmail(String email);
}
