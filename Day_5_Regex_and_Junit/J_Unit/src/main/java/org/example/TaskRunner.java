package org.example;

public class TaskRunner {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // 3 seconds
        return "Completed";
    }
}

