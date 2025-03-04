package com.codecool.backend.dao;

public interface UserDao {

    User createUser();

    int getUserById();

    int deleteUserById();

    User updateUserById();
}
