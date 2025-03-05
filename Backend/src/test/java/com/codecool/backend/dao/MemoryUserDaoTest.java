package com.codecool.backend.dao;

import com.codecool.backend.controller.dto.UserDto;
import com.codecool.backend.dao.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryUserDaoTest {
    private MemoryUserDao memoryUserDao;


    @BeforeEach
    void setUp() {
        memoryUserDao = new MemoryUserDao();
    }

    @Test
    void getUserById_returnsCorrectUser() {
        User user = new User("bill");
        int userId = memoryUserDao.createUser(user);
        User actual = memoryUserDao.getUserById(userId);
        assertEquals(userId, actual.getId());
    }

    @Test
    void updateUser_returnsTrue_whenExistingUserIsUpdated() {
        User user = new User("bill");
        int userId = memoryUserDao.createUser(user);
        user.setName("Test");
        boolean expected = true;
        boolean actual = memoryUserDao.updateUserById(user);

        assertEquals(expected, actual);
        assertEquals("Test", memoryUserDao.getUserById(userId).getName());
    }

    @Test
    void updateUser_returnsFalse_whenUserDoesNotExist() {
        User user = new User("bill");
        User user2 = new User("bob");
        int userId = memoryUserDao.createUser(user);
        boolean actual = memoryUserDao.updateUserById(user2);
        assertFalse(actual);
    }

    @Test
    void deleteUser_returnsTrue_whenUserIsDeleted() {
        User user = new User("bill");
        int userId = memoryUserDao.createUser(user);
        boolean actual = memoryUserDao.deleteUserById(userId);
        assertTrue(actual);
    }

    @Test
    void deleteUser_returnsFalse_whenUserDoesNotExist() {
        User user = new User("bill");
        int userId = memoryUserDao.createUser(user);
        boolean actual = memoryUserDao.deleteUserById(userId+1);
        assertFalse(actual);
    }

//    @Test
//    void getUserByUsernameAndPassword_returnsCorrectUser() {
//        UserDto userDto = new UserDto(1, "bill", "test@test.com");
//        User user = new User(userDto);
//        int userId = memoryUserDao.createUser(user);
//    }
}