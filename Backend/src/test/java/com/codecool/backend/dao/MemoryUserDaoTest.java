package com.codecool.backend.dao;

import com.codecool.backend.dao.model.Member;
import com.codecool.backend.controller.dto.MemberDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryUserDaoTest {
    private MemoryMemberDao memoryUserDao;
    private int userId;
    private Member user;

    @BeforeEach
    void setUp() {
        memoryUserDao = new MemoryMemberDao();
    }

    @Test
    void getUserById_returnsCorrectUser() {
        Member user = memoryUserDao.getUserById(userId);
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
        boolean actual = memoryUserDao.updateUserById(user);

        assertEquals(expected, actual);
        assertEquals("Test", memoryUserDao.getUserById(userId).getName());
    }

    @Test
    void updateUser_returnsFalse_whenUserDoesNotExist() {
        Member user = new Member("bill");
        Member user2 = new Member("bob");
        int userId = memoryUserDao.createUser(user);
        boolean actual = memoryUserDao.updateUserById(user2);
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

//    @Test
//    void getUserByUsernameAndPassword_returnsCorrectUser() {
//        UserDto userDto = new UserDto(1, "bill", "test@test.com");
//        Member user = new Member(userDto);
//        int userId = memoryUserDao.createUser(user);
//    }
}