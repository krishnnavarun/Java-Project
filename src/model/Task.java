package model;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private String assignee;
    private LocalDate deadline;
    private String status; // Pending, In Progress, Done

    public Task(int id, String title, String description, String assignee, LocalDate deadline, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.deadline = deadline;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
