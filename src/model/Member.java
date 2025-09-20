package model;

import service.TaskService;
import java.util.Scanner;

public class Member extends User {
    private TaskService taskService;

    public Member(String username, String password, TaskService taskService) {
        super(username, password, "Member");
        this.taskService = taskService;
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Member Menu ===");
            System.out.println("1. Create Task"); 
            System.out.println("2. View My Tasks");
            System.out.println("3. Update My Task");
            System.out.println("4. Mark Task Complete");
            System.out.println("0. Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> taskService.createTask(this); // Can assign to self or other
                case 2 -> taskService.viewTasks(this);
                case 3 -> taskService.updateTask(this);
                case 4 -> taskService.completeTask(this);
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
