package com.codecool.backend.service;


import com.codecool.backend.model.transaction.Transaction;
import com.codecool.backend.model.user.Member;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.PokemonRepository;
import com.codecool.backend.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private PokemonRepository pokemonRepository;

    private MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepository, transactionRepository, pokemonRepository);
    }

    @Test
    public void getMySavingsWith2Transactions() {
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(10);
        Transaction transaction2 = new Transaction();
        transaction2.setAmount(30);

        Member member = new Member();
        member.setTargetAmount(BigDecimal.valueOf(100));

        when(memberRepository.findMemberByEmail(anyString())).thenReturn(Optional.of(member));
        when(transactionRepository.getAllByMember(any())).thenReturn(Optional.of(List.of(transaction1,transaction2)));
        assertEquals(60, memberService.getMySaving("cs"));
    }
}
