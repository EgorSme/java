package com.example.demo;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserStorage storage;

    public AuthService(UserStorage storage) {
        this.storage = storage;
    }

    public boolean register(String username, String password) {
        MyUser user = new MyUser(username, password);
        return storage.addUser(user);
    }

    public boolean login(String username, String password) {
        MyUser user = storage.getUser(username);
        return user != null && user.getPassword().equals(password);
    }
}