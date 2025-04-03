package com.codecool.backend.service;

import com.codecool.backend.controller.dto.MemberCredentialsDto;
import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;
import com.codecool.backend.controller.dto.MyPokemonDto;
import com.codecool.backend.controller.exception.MemberNotFoundException;
import com.codecool.backend.model.Member;
import com.codecool.backend.model.Role;
import com.codecool.backend.model.Transaction;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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
        Member user = new Member();
        user.setName(signUpRequest.name());
        user.setPassword(encoder.encode(signUpRequest.password()));
        user.setEmail(signUpRequest.email());
        user.setRoles(Set.of(Role.ROLE_USER));
        user.setTargetAmount(new BigDecimal(0));
        memberRepository.save(user);
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

    public boolean updateUser(Member member) {
        return memberRepository.save(member) != null;
    }

    public Member findMemberByEmail(String email){
        return memberRepository.findMemberByEmail(email).orElse(null);
    }

//    public MyPokemonDto getMyPokemon(String email) {
//        Member member = memberRepository.findMemberByEmail(email)
//                .orElseThrow(MemberNotFoundException::new);
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
