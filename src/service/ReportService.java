package service;

import util.MockDB;

public class ReportService {
    public void showReport() {
        long pending = MockDB.tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase("Pending")).count();
        long inProgress = MockDB.tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase("In Progress")).count();
        long done = MockDB.tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase("Done")).count();
    }
}
