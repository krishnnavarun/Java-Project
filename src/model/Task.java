package model;

// using this package mainly for date operations like setting dealines
import java.time.LocalDate;

public class Task
{

    // initiating as private
    private int id;
    private String title;
    private String desc;
    private String assignee;
    private LocalDate deadline;
    private String status;

    // constructor
    public Task(int id, String title, String desc, String assignee, LocalDate deadline, String status){
        this.id=id;
        this.title=title;
        this.desc=desc;
        this.assignee=assignee;
        this.deadline=deadline;
        this.status=status;
    }

    public int getId()
    { 
        return id; 
    }

    public String getTitle() {
        return title; 
    }

    public void setTitle(String t) { 
        title=t; 
    }

    public String getDescription()
    { 
        return desc; 
    }

    public void setDescription(String d) 
    { 
        desc = d; 
    }

    public String getAssignee() {
        return assignee;
    }

    public LocalDate getDeadline() {
        return deadline; 
    }

    public void setDeadline(LocalDate d)
    { 
        deadline = d; 
    }

    public String getStatus() {
        return status; 
    }
    
    public void setStatus(String s) {
        status = s; 
    }

    @Override
    public String toString()
    {
        return id + ". " + title + " | " + desc + " | Assigned: " + assignee + " | Deadline: " + deadline + " | Status: " + status;
    }
}
