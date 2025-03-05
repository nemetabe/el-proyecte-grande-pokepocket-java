package com.codecool.backend.dao;

import com.codecool.backend.dao.model.Member;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class MemoryMemberDao implements MemberDao {
    private static int counter = 0;
    private Set<Member> users;

    public MemoryMemberDao() {
        this.users = new HashSet<>();
    }

    @Override
    public int createUser(Member user) {
        user.setId(counter);
        users.add(user);
        counter++;
        return user.getId();
    }

    @Override
    public Member getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteUserById(int id) {
        Member user = getUserById(id);
        if (user == null) {
            return false;
        }
        users.remove(user);
        return true;
    }

    @Override
    public boolean updateUserById(Member user) {
        Member oldUser = getUserById(user.getId());
        if (oldUser != null) {
            users.remove(oldUser);
            users.add(user);
            return true;
        }
        return false;
    }

    @Override
    public Member getUserByEmailAndPassword(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
