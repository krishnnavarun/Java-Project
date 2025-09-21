// this is used to store the tasks created and to predefine two users to check the program is working properly or not.

package util;

import model.User;
import model.Leader;
import model.Member;
import service.TaskService;
import service.ReportService;
import java.util.*;

public class MockDB{

    public static List<User> users = new ArrayList<>();

    //
    public static List<model.Task> tasks = new ArrayList<>();


    // we have predefined two users (one as leader an done as member) to check the program.
    public static void init(TaskService ts, ReportService rs){
        users.add(new Leader("leader1","pass123",ts,rs));
        users.add(new Member("member1","pass123",ts));
    }
}
