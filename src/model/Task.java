package model;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private String assignee;
    private LocalDate dueDate;
    private String status;

    public Task(int id, String title, String description, String assignee, LocalDate dueDate, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getAssignee() { return assignee; }
    public LocalDate getDueDate() { return dueDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return id + " | " + title + " | " + assignee + " | " + dueDate + " | " + status;
    }
}