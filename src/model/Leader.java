package model;

import service.TaskService;
import service.ReportService;
import util.MockDB;
import java.util.Scanner;

public class Leader extends User {
    private TaskService taskService;
    private ReportService reportService;

    public Leader(String username, String password, TaskService taskService, ReportService reportService) {
        super(username, password, "Leader");
        this.taskService = taskService;
        this.reportService = reportService;
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Leader Menu ===");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Add Team Member");
            System.out.println("5. Show Report");
            System.out.println("0. Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> taskService.createTask(this);
                case 2 -> taskService.viewTasks(this);
                case 3 -> taskService.updateTask(this);
                case 4 -> {
                    System.out.print("Enter new member username: ");
                    String uname = sc.next();
                    System.out.print("Enter password: ");
                    String pass = sc.next();
                    MockDB.users.add(new Member(uname, pass, taskService));
                    System.out.println("✅ Member added!");
                }
                case 5 -> reportService.showReport();
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
