package service;

import model.User;
import util.MockDB;

public class AuthService {
    public User login(String username, String password) {
        return MockDB.users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
