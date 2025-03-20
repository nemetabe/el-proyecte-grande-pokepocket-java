package com.codecool.backend.model;

import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Member {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Transaction> transactions;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Member(MemberRegistrationDto memberRegistrationDto) {
        name = memberRegistrationDto.name();
        email = memberRegistrationDto.email();
        password = memberRegistrationDto.password();
    }

    public Member(MemberDto userDto) {
        id = userDto.id();
        name = userDto.name();
        email = userDto.email();
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id
                && Objects.equals(name, member.name)
                && Objects.equals(email, member.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

}



