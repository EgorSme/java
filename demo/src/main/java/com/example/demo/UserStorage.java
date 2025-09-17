package com.example.demo;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

@Component
public class UserStorage {
    private final ConcurrentMap<String, MyUser> users = new ConcurrentHashMap<>();

    public boolean addUser(MyUser user) {
        if (users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    }

    public MyUser getUser(String username) {
        return users.get(username);
    }
}
