package model;

import service.TaskService;
import service.ReportService;
import java.util.Scanner;

public class Member extends User {
    private TaskService taskService;
    private ReportService reportService;

    public Member(String username, String password, TaskService taskService, ReportService reportService) {
        super(username, password, "Member"); // role = Member
        this.taskService = taskService;
        this.reportService = reportService;
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Member Menu ===");
            System.out.println("1. View Tasks");
            System.out.println("2. Update Task");
            System.out.println("3. Create Task (self-assigned)");
            System.out.println("0. Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> taskService.viewTasks(this);
                case 2 -> taskService.updateTask(this);
                case 3 -> taskService.createTask(this); // self-assigned
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
