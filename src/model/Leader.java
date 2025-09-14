package model;

import java.util.Scanner;

public class Leader extends User {

    public Leader(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLeader Menu");
            System.out.println("1. Create Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Create Task selected");
                case 2 -> System.out.println("Update Task selected");
                case 3 -> System.out.println("Delete Task selected");
                case 4 -> System.out.println("View All Tasks selected");
                case 5 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
