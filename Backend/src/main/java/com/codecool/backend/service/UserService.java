package com.codecool.backend.service;

import com.codecool.backend.controller.dto.UserCredentialsDto;
import com.codecool.backend.controller.dto.UserDto;
import com.codecool.backend.controller.dto.UserRegistrationDto;
import com.codecool.backend.controller.exceptions.UserNotFoundException;
import com.codecool.backend.dao.UserDao;
import com.codecool.backend.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int logIn(UserCredentialsDto userCredentials) {
        User user = userDao.getUserByEmailAndPassword(userCredentials.email(), userCredentials.password());
        if (user == null) throw new UserNotFoundException();
        return user.getId();
    }

    public int signUp(UserRegistrationDto userRegistration) {
        User user = new User(userRegistration);
        return userDao.createUser(user);
    }

    public UserDto getUser(int id) {
        User user = userDao.getUserById(id);
        if (user == null) throw new UserNotFoundException();
        return new UserDto(user);
    }

    public boolean deleteUser(int id) {
        return userDao.deleteUserById(id);
    }

    public boolean updateUser(UserDto userDto) {
        User user = new User(userDto);
        return userDao.updateUserById(user);
    }
}
