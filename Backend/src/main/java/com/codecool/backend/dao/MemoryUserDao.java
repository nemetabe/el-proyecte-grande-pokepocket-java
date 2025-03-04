package com.codecool.backend.dao;

import com.codecool.backend.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
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
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteUserById(int id) {
        User user = getUserById(id);
        if (user == null) {
            return false;
        }
        users.remove(user);
        return true;
    }

    @Override
    public boolean updateUserById(User user) {
        User oldUser = getUserById(user.getId());
        if (oldUser == null) {
            return false;
        }
        users.remove(oldUser);
        users.add(user);
        return true;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
