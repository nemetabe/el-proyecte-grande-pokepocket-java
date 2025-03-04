package com.codecool.backend.dao;

import com.codecool.backend.dao.model.User;

public interface UserDao {

    int createUser(User user);

    User getUserById(int id);

    boolean deleteUserById(int id);

    boolean updateUserById(User user);
}
