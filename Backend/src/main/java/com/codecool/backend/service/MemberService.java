package com.codecool.backend.service;

import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;
import com.codecool.backend.controller.exception.MemberNotFoundException;
import com.codecool.backend.model.Member;
import com.codecool.backend.model.Role;
import com.codecool.backend.model.Transaction;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, TransactionRepository transactionRepository) {
        this.memberRepository = memberRepository;
        this.transactionRepository = transactionRepository;
    }


    public ResponseEntity<Void> register(MemberRegistrationDto signUpRequest, PasswordEncoder encoder) {
        Member member = new Member();
        member.setName(signUpRequest.name());
        member.setPassword(encoder.encode(signUpRequest.password()));
        member.setEmail(signUpRequest.email());
        member.setRoles(Set.of(Role.ROLE_USER));
        member.setTargetAmount(new BigDecimal(0));
        memberRepository.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public MemberDto getMember(int id) {
        Member member = memberRepository.getMemberById(id)
                .orElseThrow(MemberNotFoundException::new);
        return new MemberDto(member);
    }

    public boolean deleteMember(int id) {
        return memberRepository.deleteMemberById(id);
    }

    public boolean updateMember(Member member) {
        return memberRepository.save(member) != null;
    }

    public Member findMemberByEmail(String email){
        return memberRepository.findMemberByEmail(email).orElse(null);
    }

//    public MyPokemonDto getMyPokemon(String email) {
//        Member member = memberRepository.findMemberByEmail(email)
//                .orElseThrow(MemberNotFoundException::new);
//        member
//    }


    public int getMySaving(String email) {
        Member member = memberRepository.findMemberByEmail(email)
                .orElseThrow(MemberNotFoundException::new);
        List<Transaction> transactions = transactionRepository.getAllByMember(member).orElse(null);
        return member.getTargetAmount().intValue()-(transactions
                .stream()
                .mapToInt(Transaction::getAmount).sum());
    }
}
