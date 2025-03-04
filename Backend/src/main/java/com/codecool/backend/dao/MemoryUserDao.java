package com.codecool.backend.dao;

import com.codecool.backend.dao.model.User;

import java.util.HashSet;
import java.util.Set;

public class MemoryUserDao implements UserDao {
    private static int counter = 0;
    private Set<User> users;

    public MemoryUserDao() {
        this.users = new HashSet<>();
    }

    @Override
    public int createUser(User user) {
        user.setId(counter);
        users.add(user);
        counter++;
        return user.getId();
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean deleteUserById(int id) {
        try {
            return users.remove(getUserById(id));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateUserById(User user) {
        User existingUser = getUserById(user.getId());
        boolean result = false;
        if (existingUser != null) {
            users.remove(existingUser);
            users.add(user);
            result = true;
        }
        return result;
    }
}
