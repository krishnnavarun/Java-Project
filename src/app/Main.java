package app;

import model.Leader;
import model.Member;
import model.User;
import service.ReportService;
import service.TaskService;
import util.MockDB;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        ReportService reportService = new ReportService();

        // Add demo users
        MockDB.users.add(new Leader("leader1", "pass123", taskService, reportService));
        MockDB.users.add(new Member("member1", "pass123", taskService, reportService));

        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        User currentUser = MockDB.users.stream()
                .filter(user -> user.getUsername().equals(u) && user.getPassword().equals(p))
                .findFirst()
                .orElse(null);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome " + currentUser.getUsername());
            currentUser.showMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}