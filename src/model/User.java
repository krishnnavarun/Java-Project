package model;

// This is the base class for all the users
public abstract class User
{

    //initiating it as a protected
    protected String username;
    protected String password;
    protected String role;

    //constructor
    public User(String username, String password, String role)
    {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //to login using the username
    public String getUsername()
    { 
        return username; 
    }

    // to identify the role using the username and password
    public String getRole() { 
        return role; 
    }

    //to check the password for the username entered
    public boolean checkPassword(String pw)
    { 
        return password.equals(pw); 
    }

    // all the users are abled to see their menus respectively to their roles
    public abstract void showMenu();

}


