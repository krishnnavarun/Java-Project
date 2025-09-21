package model;

// importing this package to access the task assigning and checking the works respectively to their roles.
import service.TaskService;

import java.util.Scanner;

public class Member extends User
{
    private TaskService ts;

    public Member(String username, String password, TaskService ts)
    {
        super(username,password,"Member");
        this.ts = ts;
    }

    @Override
    public void showMenu(){

        Scanner sc = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\n===== Member View =====");
            System.out.println("1. Create Task");
            System.out.println("2. View self Tasks");
            System.out.println("3. Update self Task");
            System.out.println("4. Mark Tasks as Complete");
            System.out.println("0. Logged out from member");
            System.out.print("Choose: ");
            choice = sc.nextInt(); 

            // to move to the nextLine
            sc.nextLine();


            // switch case to select the task needed to perform by the member.
            switch(choice)
            {

                // to log out
                case 0 : System.out.println("Logged out from member...");
                break;
                // can create task to himself
                case 1 : ts.createTask(this); 
                break;
                // can view task created by him
                case 2 : ts.viewTasks(this);
                break;
                // can update task created by him
                case 3 : ts.updateTask(this);
                break;
                // can complete task assigned by him
                case 4 : ts.completeTask(this);
                break;

                // if unnecessary key pressed the invalid choice occurs
                default : System.out.println("Invalid choice !");
            }

        }
        while(choice != 0);
    }
}
