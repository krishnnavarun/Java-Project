package service;

import util.MockDB;

public class ReportService {
    public void showReport() {
        long pending = MockDB.tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase("Pending")).count();
        long done = MockDB.tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase("Done")).count();

        System.out.println("\n=== Task Report ===");
        System.out.println("Pending: " + pending);
        System.out.println("Done: " + done);
    }
}
