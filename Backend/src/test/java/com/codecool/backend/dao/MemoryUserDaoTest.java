package com.codecool.backend.dao;

import com.codecool.backend.dao.model.Member;
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
        user = new Member("bill");

        userId = memoryUserDao.createUser(user);
    }

    @Test
    void getUser() {
        Member actual = memoryUserDao.getUserById(userId);
        assertEquals(userId, actual.getId());
    }

}