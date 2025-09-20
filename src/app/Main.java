package app;

import model.User;
import service.TaskService;
import service.ReportService;
import service.AuthService;
import util.MockDB;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        ReportService reportService = new ReportService();
        MockDB.init(taskService, reportService);

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Task Manager ===");
        System.out.print("Username: "); 
        String uname = sc.nextLine();
        System.out.print("Password: "); 
        String pass = sc.nextLine();

        User currentUser = AuthService.login(uname, pass);
        if(currentUser != null) {
            System.out.println("Login successful as " + currentUser.getRole());
            currentUser.showMenu();
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}
