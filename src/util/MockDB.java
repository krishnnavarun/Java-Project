package util;

import model.User;
import model.Leader;
import model.Member;
import service.TaskService;
import service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class MockDB {
    public static List<User> users = new ArrayList<>();
    public static List<model.Task> tasks = new ArrayList<>();

    public static void init(TaskService taskService, ReportService reportService) {
        users.add(new Leader("leader1", "pass123", taskService, reportService));
        users.add(new Member("member1", "pass123", taskService));
    }
}
