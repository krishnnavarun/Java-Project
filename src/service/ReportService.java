package service;

import util.MockDB;

public class ReportService
{
    public void showReport()
    {
        //initially makes the pedning and done tasks as zero and after updating it will change
        int pending = 0;
        int done = 0;

        for(var t: MockDB.tasks){

            //here the changes will happen for pending task if the condition satifies
            if(t.getStatus().equalsIgnoreCase("Pending")){
                pending++;
            }

            //here the changes will happen for done task if the condition satifies
            else if(t.getStatus().equalsIgnoreCase("Done")){
                done++;
            }
        }

        System.out.println("\n--- Report ---");
        System.out.println("Pending: " + pending);
        System.out.println("Done: " + done);
    }
}
