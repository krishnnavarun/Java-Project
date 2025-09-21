package service;


import model.User;
import util.MockDB;

//this is to check the given username and passwords are correct or not.
public class AuthService{
    public static User login(String uname, String pw)
    {
        for(User u: MockDB.users)
        {
            if(u.getUsername().equals(uname) && u.checkPassword(pw)){
                return u;
            }
        }
        return null;
    }
}
