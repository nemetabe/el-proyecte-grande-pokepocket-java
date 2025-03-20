package com.codecool.backend.service;

import com.codecool.backend.controller.dto.MemberCredentialsDto;
import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;
import com.codecool.backend.controller.exception.MemberNotFoundException;
import com.codecool.backend.model.Member;
import com.codecool.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int logIn(MemberCredentialsDto memberCredentials) {
        Member member = memberRepository.getMemberByEmailAndPassword(memberCredentials.email(), memberCredentials.password())
                .orElseThrow(MemberNotFoundException::new);
        return member.getId();
    }

    public int signUp(MemberRegistrationDto memberRegistration) {
        Member member = new Member(memberRegistration);
        return memberRepository.save(member).getId();
    }

    public MemberDto getMember(int id) {
        Member member = memberRepository.getMemberById(id)
                .orElseThrow(MemberNotFoundException::new);
        return new MemberDto(member);
    }

    public boolean deleteMember(int id) {
        return memberRepository.deleteMemberById(id);
    }

    public boolean updateUser(MemberDto userDto) {
        Member member = new Member(userDto);
        return memberRepository.save(member) != null;
    }
}
