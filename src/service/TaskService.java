package service;

import model.Task;
import model.User;
import util.MockDB;
import java.time.LocalDate;
import java.util.Scanner;

public class TaskService {
    private static int idCounter = 1;

    public void createTask(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        String assignee;

        if(user.getRole().equalsIgnoreCase("Leader")) {
            assignee = assignUser(); // Leader can choose anyone
        } else { // Member
            System.out.println("Assign task to: 1) Myself  2) Another Member");
            System.out.print("Choose: ");
            int choice = sc.nextInt(); sc.nextLine();

            if(choice == 1) {
                assignee = user.getUsername(); // Assign to self
            } else {
                assignee = assignUser();       // Assign to another member
            }
        }

        System.out.print("Enter Deadline (YYYY-MM-DD): ");
        LocalDate deadline = LocalDate.parse(sc.nextLine());

        Task task = new Task(idCounter++, title, desc, assignee, deadline, "Pending");
        MockDB.tasks.add(task);

        System.out.println("Task assigned to " + assignee);
        System.out.println("ALERT: Task '" + title + "' due by " + deadline);
    }

    private String assignUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Assignee Username: ");
        return sc.nextLine();
    }

    public void viewTasks(User user) {
        System.out.println("\n=== Task List ===");
        MockDB.tasks.stream()
            .filter(t -> user.getRole().equalsIgnoreCase("Leader") || t.getAssignee().equals(user.getUsername()))
            .forEach(System.out::println);
    }

    public void updateTask(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task ID to update: ");
        int id = sc.nextInt(); sc.nextLine();

        for(Task t : MockDB.tasks) {
            if(t.getId() == id && (user.getRole().equalsIgnoreCase("Leader") || t.getAssignee().equals(user.getUsername()))) {
                System.out.print("New Title: "); t.setTitle(sc.nextLine());
                System.out.print("New Description: "); t.setDescription(sc.nextLine());
                System.out.print("New Deadline (YYYY-MM-DD): ");
                String d = sc.nextLine();
                if(!d.isEmpty()) t.setDeadline(LocalDate.parse(d));

                System.out.println("Task updated!");
                System.out.println("ALERT: Task '" + t.getTitle() + "' updated, deadline: " + t.getDeadline());
                return;
            }
        }
        System.out.println("Task not found or access denied.");
    }

    public void completeTask(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task ID to mark complete: ");
        int id = sc.nextInt();

        for(Task t : MockDB.tasks) {
            if(t.getId() == id && t.getAssignee().equals(user.getUsername())) {
                t.setStatus("Done");
                System.out.println("✅ Task marked as Done!");
                return;
            }
        }
        System.out.println("Task not found or cannot complete.");
    }
}
