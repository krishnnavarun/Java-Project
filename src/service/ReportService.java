package service;

import util.MockDB;

public class ReportService {
    public void showReport() {
        long pending = MockDB.tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase("Pending")).count();
        long inProgress = MockDB.tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase("In Progress")).count();
        long done = MockDB.tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase("Done")).count();

        System.out.println("=== Task Report ===");
        System.out.println("Pending: " + pending);
        System.out.println("In Progress: " + inProgress);
        System.out.println("Done: " + done);
    }
}
