package com.codecool.backend.service;


import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;
import com.codecool.backend.controller.exception.MemberNotFoundException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
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

    @Test
    public void register_validMemberData_returnsCreatedStatus() {
        // Arrange
        MemberRegistrationDto registrationDto = new MemberRegistrationDto("Test User", "test@test.com", "password123");
        PasswordEncoder encoder = mock(PasswordEncoder.class);
        when(encoder.encode(anyString())).thenReturn("encodedPassword");
        when(memberRepository.save(any(Member.class))).thenReturn(new Member());

        // Act
        ResponseEntity<Void> response = memberService.register(registrationDto, encoder);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void getMember_existingId_returnsMemberDto() {
        // Arrange
        int memberId = 1;
        Member member = new Member();
        member.setId(memberId);
        member.setName("Test User");
        member.setEmail("test@test.com");
        
        when(memberRepository.getMemberById(memberId)).thenReturn(Optional.of(member));

        // Act
        MemberDto result = memberService.getMember(memberId);

        // Assert
        assertEquals(memberId, result.id());
        assertEquals("Test User", result.name());
        assertEquals("test@test.com", result.email());
    }

    @Test
    public void getMember_nonExistingId_throwsMemberNotFoundException() {
        // Arrange
        int memberId = 999;
        when(memberRepository.getMemberById(memberId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(MemberNotFoundException.class, () -> memberService.getMember(memberId));
    }

    @Test
    public void deleteMember_existingId_returnsTrue() {
        // Arrange
        int memberId = 1;
        when(memberRepository.deleteMemberById(memberId)).thenReturn(true);

        // Act
        boolean result = memberService.deleteMember(memberId);

        // Assert
        assertTrue(result);
    }

    @Test
    public void updateMember_validMember_returnsTrue() {
        // Arrange
        Member member = new Member();
        member.setId(1);
        member.setName("Updated Name");
        when(memberRepository.save(any(Member.class))).thenReturn(member);

        // Act
        boolean result = memberService.updateMember(member);

        // Assert
        assertTrue(result);
    }

    @Test
    public void findMemberByEmail_existingEmail_returnsMember() {
        // Arrange
        String email = "test@test.com";
        Member member = new Member();
        member.setEmail(email);
        when(memberRepository.findMemberByEmail(email)).thenReturn(Optional.of(member));

        // Act
        Member result = memberService.findMemberByEmail(email);

        // Assert
        assertNotNull(result);
        assertEquals(email, result.getEmail());
    }

    @Test
    public void findMemberByEmail_nonExistingEmail_returnsNull() {
        // Arrange
        String email = "nonexisting@test.com";
        when(memberRepository.findMemberByEmail(email)).thenReturn(Optional.empty());

        // Act
        Member result = memberService.findMemberByEmail(email);

        // Assert
        assertNull(result);
    }
}
