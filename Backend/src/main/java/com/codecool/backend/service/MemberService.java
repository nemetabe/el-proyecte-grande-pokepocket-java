package com.codecool.backend.service;

import com.codecool.backend.controller.dto.MemberCredentialsDto;
import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;
import com.codecool.backend.controller.exceptions.MemberNotFoundException;
import com.codecool.backend.dao.MemberDao;
import com.codecool.backend.dao.model.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberDao userDao;

    public MemberService(MemberDao userDao) {
        this.userDao = userDao;
    }

    public int logIn(MemberCredentialsDto userCredentials) {
        Member user = userDao.getUserByEmailAndPassword(userCredentials.email(), userCredentials.password());
        if (user == null) throw new MemberNotFoundException();
        return user.getId();
    }

    public int signUp(MemberRegistrationDto userRegistration) {
        Member user = new Member(userRegistration);
        return userDao.createUser(user);
    }

    public MemberDto getUser(int id) {
        Member user = userDao.getUserById(id);
        if (user == null) throw new MemberNotFoundException();
        return new MemberDto(user);
    }

    public boolean deleteUser(int id) {
        return userDao.deleteUserById(id);
    }

    public boolean updateUser(MemberDto userDto) {
        Member user = new Member(userDto);
        return userDao.updateUser(user);
    }
}
