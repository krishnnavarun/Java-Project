package model;

import util.MockDB;
import service.TaskService;
import service.ReportService;
import java.util.Scanner;

public class Leader extends User {

    private TaskService taskService;
    private ReportService reportService;
    private Scanner sc = new Scanner(System.in);

    public Leader(String username, String password, TaskService taskService, ReportService reportService) {
        super(username, password, "Leader");
        this.taskService = taskService;
        this.reportService = reportService;
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\n=== Leader Menu ===");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Add Team Member");
            System.out.println("5. Show Report");
            System.out.println("0. Logout");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> taskService.createTask(this);         // create task
                case 2 -> taskService.viewTasks(this);          // view tasks
                case 3 -> taskService.updateTask(this);         // update any team member task
                case 4 -> addTeamMember();                       // add a new member
                case 5 -> reportService.showReport();           // show report
                case 0 -> {
                    return;                                     // logout
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addTeamMember() {
        System.out.print("Enter new member username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Automatically add to MockDB with leader's taskService/reportService
        MockDB.users.add(new Member(username, password, taskService, reportService));
        System.out.println("Member " + username + " added successfully!");
    }
}
