package app;
import model.User;
import service.TaskService;
import service.ReportService;
import service.AuthService;
import util.MockDB;
import java.util.Scanner;

//main function
public class Main {
    public static void main(String[] args) {

        TaskService ts = new TaskService();
        ReportService rs = new ReportService();
        MockDB.init(ts,rs);

        Scanner sc = new Scanner(System.in);
        System.out.println(" === Task Manager === ");
        System.out.print("Username: "); 

        String u = sc.nextLine();
        System.out.print("Password: "); 

        String p = sc.nextLine();

        User me = AuthService.login(u,p);

        if(me != null)
        {
            System.out.println("Logged in as " + me.getRole());
            me.showMenu();
        }
        else
        {
            System.out.println("Wrong credentials");
        }
    }
}

