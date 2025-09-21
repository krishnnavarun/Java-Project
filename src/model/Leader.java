package model;

// importing this package to access the task assigning and checking the works respectively to their roles.
import service.TaskService;

//importing this to see the reports of the members
import service.ReportService;

//importing this to identify  the predefined username and password.
import util.MockDB;

import java.util.Scanner;

public class Leader extends User {
    //initiating taskservices and reportservices as private
    private TaskService ts;
    private ReportService rs;

    public Leader(String username, String password, TaskService ts, ReportService rs)
    {
        super(username,password,"Leader");
        this.ts = ts;
        this.rs = rs;
    }

    @Override
    public void showMenu()
    {
        Scanner sc = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\n=== Leader View ===");
            System.out.println("1.Create Task");
            System.out.println("2.View Tasks");
            System.out.println("3.Update Task");
            System.out.println("4.Add Team Member");
            System.out.println("5.Show Report");
            System.out.println("0.Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            // Switch case to select the task to perform by the leader
            switch(choice)
            {
                // to logout
                case 0 : System.out.println("Logged out from leader");
                break;

                // to create task for the team members
                case 1 : ts.createTask(this);
                break;

                // to view the taskes created for  the team members
                case 2 : ts.viewTasks(this);
                break;

                // to update the task created for the team members
                case 3 : ts.updateTask(this);
                break;

                // to add the members in the team
                case 4 : {
                    System.out.print("New member username: ");
                    String uname = sc.next();
                    System.out.print("Password: ");
                    String pass = sc.next();
                    MockDB.users.add(new Member(uname,pass,ts));
                    System.out.println("Member added!");
                }
                break;

                // to see the report of the team
                case 5 : rs.showReport();
                break;
                
                default : System.out.println("Invalid choice !");
            }

        }
        while(choice != 0);
    }
}
