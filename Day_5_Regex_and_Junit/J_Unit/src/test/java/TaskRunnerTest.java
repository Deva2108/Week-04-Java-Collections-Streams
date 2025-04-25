import org.example.TaskRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

public class TaskRunnerTest {

    TaskRunner runner = new TaskRunner();

    @Test
    @Timeout(2) // seconds
    void testLongRunningTaskTimeout() throws InterruptedException {
        runner.longRunningTask();
    }
}
