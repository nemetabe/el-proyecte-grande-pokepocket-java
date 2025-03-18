package com.codecool.backend.repository;

import com.codecool.backend.controller.dto.MemberRegistrationDto;
import com.codecool.backend.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberDaoTest {
    private MemoryMemberDao memoryUserDao;

    @BeforeEach
    void setUp() {
        memoryUserDao = new MemoryMemberDao();
    }

    @Test
    void getUserById_returnsCorrectUser() {
        Member user = new Member("bob");
        int expected = 1;
        int userId = memoryUserDao.createUser(user);
        Member actual = memoryUserDao.getUserById(userId);
        assertEquals(userId, actual.getId());
    }

    @Test
    void updateUser_returnsTrue_whenExistingUserIsUpdated() {
        Member user = new Member("bill");
        int userId = memoryUserDao.createUser(user);
        user.setName("Test");
        boolean expected = true;
        boolean actual = memoryUserDao.updateUser(user);

        assertEquals(expected, actual);
        assertEquals("Test", memoryUserDao.getUserById(userId).getName());
    }

    @Test
    void updateUser_returnsFalse_whenUserDoesNotExist() {
        Member user = new Member("bill");
        Member user2 = new Member("bob");
        user2.setId(2);
        int userId = memoryUserDao.createUser(user);
        boolean actual = memoryUserDao.updateUser(user2);
        assertFalse(actual);
    }

    @Test
    void deleteUser_returnsTrue_whenUserIsDeleted() {
        Member user = new Member("bill");
        int userId = memoryUserDao.createUser(user);
        boolean actual = memoryUserDao.deleteUserById(userId);
        assertTrue(actual);
    }

    @Test
    void deleteUser_returnsFalse_whenUserDoesNotExist() {
        Member user = new Member("bill");
        int userId = memoryUserDao.createUser(user);
        boolean actual = memoryUserDao.deleteUserById(userId+1);
        assertFalse(actual);
    }

    @Test
    void getUserByUsernameAndPassword_returnsCorrectUser() {
        String name = "bob";
        String email = "bob@gmail.com";
        String password = "password";

        MemberRegistrationDto userDto = new MemberRegistrationDto(name, email, password);
        Member user = new Member(userDto);
        int userId = memoryUserDao.createUser(user);

        assertEquals(userId, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
    }
}