import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        // Create a Queue of Strings
        Queue<String> queue = new LinkedList<>();

        // === Enqueue (Add elements to the queue) ===
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        System.out.println("Queue after enqueue: " + queue);
        // Output: [Alice, Bob, Charlie]

        // === Peek (Look at the front element) ===
        System.out.println("Front of queue: " + queue.peek()); 
        // Output: Alice

        // === Dequeue (Remove elements from the front) ===
       
        System.out.println("Dequeued: " + queue.poll());
        System.out.println("Queue after dequeue: " + queue);
        // Output:
        // Dequeued: Alice
        // Queue after dequeue: [Bob, Charlie]
    }
}
