package com.codecool.backend.dao;

import com.codecool.backend.dao.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryUserDaoTest {
    private MemoryUserDao memoryUserDao;
    private int userId;
    private User user;

    @BeforeEach
    void setUp() {
        memoryUserDao = new MemoryUserDao();
        user = new User("bill");

        userId = memoryUserDao.createUser(user);
    }

    @Test
    void getUser() {
        User actual = memoryUserDao.getUserById(userId);
        assertEquals(userId, actual.getId());
    }

}