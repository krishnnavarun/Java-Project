package model;

/**
 * Base abstract class for all users.
 */
public abstract class User {
    protected String username;
    protected String password;
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getRole() { return role; }

    public boolean checkPassword(String pw) {
        return this.password.equals(pw);
    }

    // Each user type implements its own menu
    public abstract void showMenu();
}
