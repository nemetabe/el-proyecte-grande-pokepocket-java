package com.codecool.backend.dao;

import com.codecool.backend.dao.model.User;

public interface UserDao {

    User createUser();

    int getUserById();

    int deleteUserById();

    User updateUserById();
}
