package service;

import model.User;
import util.MockDB;

public class AuthService {
    public static User login(String username, String password) {
        return MockDB.users.stream()
            .filter(u -> u.getUsername().equals(username) && u.checkPassword(password))
            .findFirst()
            .orElse(null);
    }
}
