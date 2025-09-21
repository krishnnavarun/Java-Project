package service;

import model.Task;
import model.User;
import util.MockDB;
import java.time.LocalDate;
import java.util.Scanner;

public class TaskService {

   // this is the counter for tasks
   private static int nextId = 1; 
 
   // to create tasks
   public void createTask(User curUser){
       Scanner sc = new Scanner(System.in);

       System.out.print("Task title : "); 
       String taskTitle = sc.nextLine();

       System.out.print("Description : "); 
       String taskDesc = sc.nextLine();

       String assignee;

       // if the leader is assigning then this works
       if (curUser.getRole().equalsIgnoreCase("Leader"))
       {
           assignee = pickUser();
       }

       // this is for the self assignment of tasks
       else
       {
           System.out.println("Assign to: 1");
           System.out.print("Choice: ");
           int choice = sc.nextInt(); 
           sc.nextLine();

           if(choice == 1)
           {
            assignee = curUser.getUsername();
           }

           else
           {
            assignee = pickUser();
           }
 
       }

       System.out.print("Deadline(yyyy-mm-dd): ");
       LocalDate dl = LocalDate.parse(sc.nextLine());

       Task tmpTask = new Task(nextId++, taskTitle, taskDesc, assignee, dl, "Pending");
       MockDB.tasks.add(tmpTask);

       System.out.println("Task created: " + taskTitle);
       System.out.println("Alert: " + taskTitle + " due " + dl);
   }

   private String pickUser() {
       Scanner sc = new Scanner(System.in);
       System.out.print("Who should do it : "); 
       String user = sc.nextLine();
       return user;
   }

   public void viewTasks(User me){
       System.out.println("\n--- Your tasks ---");
       for (Task t : MockDB.tasks) {
           if(me.getRole().equalsIgnoreCase("Leader") || t.getAssignee().equals(me.getUsername()))
               System.out.println(t);
       }
   }

   public void updateTask(User me){
       Scanner sc = new Scanner(System.in);
       System.out.print("Which task id to update : "); 
       int id = sc.nextInt(); 
       sc.nextLine();

       Task found = null;
       for(Task t: MockDB.tasks)
       {
           if(t.getId() == id)
           { 
            found = t; 
            break; 
           }
       }

       if(found != null && (me.getRole().equalsIgnoreCase("Leader") || found.getAssignee().equals(me.getUsername())))
       {
           System.out.print("New title : "); 
           found.setTitle(sc.nextLine());
           System.out.print("New desc : "); 
           found.setDescription(sc.nextLine());
           System.out.print("New deadline (yyyy-mm-dd) : "); 
           String d = sc.nextLine();
           if(!d.isEmpty()){
            found.setDeadline(LocalDate.parse(d));
           }

           System.out.println("Task updated : " + found.getTitle() + " due " + found.getDeadline());
       } 
       else 
       {
           System.out.println("Not found");
       }
   }

   public void completeTask(User me)
   {
       Scanner sc = new Scanner(System.in);
       System.out.print("Task id to mark done : "); 
       int id = sc.nextInt();

       boolean found = false;
       for(Task t: MockDB.tasks){
           if(t.getId() == id && t.getAssignee().equals(me.getUsername()))
           {
               t.setStatus("Done"); 
               System.out.println("Task completed!");
               found = true; 
               break;
           }
       }

       if(!found){
        System.out.println("Task not found");
       }
   }
}


