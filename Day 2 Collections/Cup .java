import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        Queue<String> taskQueue = new LinkedList<>();

        // Adding tasks to the queue
        taskQueue.add("Send email");
        taskQueue.add("Generate report");
        taskQueue.add("Backup database");

        // Processing tasks one by one (scheduled execution)
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();  // Schedule & execute (remove)
            System.out.println("Executing: " + task);
        }
    }
}
