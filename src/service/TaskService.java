package service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Task;
import model.User;
import util.MockDB;

public class TaskService {
    private Scanner sc = new Scanner(System.in);

    // Create a task
    public void createTask(User user) {
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter description: ");
        String desc = sc.nextLine();

        System.out.print("Enter deadline (yyyy-mm-dd, optional): ");
        String deadlineInput = sc.nextLine();
        LocalDate deadline = deadlineInput.isEmpty() ? null : LocalDate.parse(deadlineInput);

        // Leader can assign, member assigns to self
        String assignee = user.getRole().equalsIgnoreCase("Leader") ? assignUser() : user.getUsername();

        int newId = MockDB.tasks.size() + 1;
        Task task = new Task(newId, title, desc, assignee, deadline, "Pending");
        MockDB.tasks.add(task);

        System.out.println("Task created successfully!");
    }

    // Assign task to a member (leader only)
    private String assignUser() {
        System.out.println("Available members:");
        List<User> members = MockDB.users.stream()
                .filter(u -> u.getRole().equalsIgnoreCase("Member"))
                .collect(Collectors.toList());

        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ". " + members.get(i).getUsername());
        }

        System.out.print("Choose assignee: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        if (choice < 1 || choice > members.size()) {
            System.out.println("Invalid choice. Assigning task to leader instead.");
            return "Leader";
        }

        return members.get(choice - 1).getUsername();
    }

    // View tasks
    public void viewTasks(User user) {
        List<Task> tasksToShow = MockDB.tasks.stream()
                .filter(t -> user.getRole().equalsIgnoreCase("Leader") || t.getAssignee().equals(user.getUsername()))
                .collect(Collectors.toList());

        if (tasksToShow.isEmpty()) {
            System.out.println("No tasks to show.");
            return;
        }

        System.out.println("=== Tasks ===");
        for (Task t : tasksToShow) {
            System.out.println(t);
        }
    }

    // Update tasks
    public void updateTask(User user) {
        if (MockDB.tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        viewTasks(user);

        System.out.print("Enter Task ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        Task taskToUpdate = null;
        for (Task t : MockDB.tasks) {
            if (t.getId() == id && (user.getRole().equalsIgnoreCase("Leader") || t.getAssignee().equals(user.getUsername()))) {
                taskToUpdate = t;
                break;
            }
        }

        if (taskToUpdate == null) {
            System.out.println("Task not found or you cannot update this task.");
            return;
        }

        System.out.print("Enter new title (leave empty to keep current): ");
        String title = sc.nextLine();
        if (!title.isEmpty()) taskToUpdate.setTitle(title);

        System.out.print("Enter new description (leave empty to keep current): ");
        String desc = sc.nextLine();
        if (!desc.isEmpty()) taskToUpdate.setDescription(desc);

        System.out.print("Enter new status (Pending/In Progress/Done, leave empty to keep current): ");
        String status = sc.nextLine();
        if (!status.isEmpty()) taskToUpdate.setStatus(status);

        System.out.println("Task updated successfully!");
    }
}
