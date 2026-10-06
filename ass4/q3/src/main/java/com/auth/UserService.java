package com.auth;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private Map<String, User> users = new HashMap<>();
    private int nextId = 1;

    public User register(User user) {
        if (users.containsKey(user.getUsername()))
            throw new RuntimeException("Username already exists");
        user.setId(nextId++);
        users.put(user.getUsername(), user);
        return user;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user == null || !user.getPassword().equals(password))
            throw new RuntimeException("Invalid username or password");
        return user;
    }

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }
}
