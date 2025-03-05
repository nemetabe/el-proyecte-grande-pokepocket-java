package com.codecool.backend.dao;

import com.codecool.backend.dao.model.Member;

public interface MemberDao {

    int createUser(Member user);

    Member getUserById(int id);

    boolean deleteUserById(int id);

    boolean updateUserById(Member user);

    Member getUserByEmailAndPassword(String email, String password);
}
