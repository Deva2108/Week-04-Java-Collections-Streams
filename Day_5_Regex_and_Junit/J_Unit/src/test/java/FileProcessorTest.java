import org.example.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    FileProcessor processor;
    String testFile = "testfile.txt";

    @BeforeEach
    void setup() {
        processor = new FileProcessor();
    }

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(testFile));
    }

    @Test
    void testWriteAndRead() throws IOException {
        String content = "Hello, world!";
        processor.writeToFile(testFile, content);
        String result = processor.readFromFile(testFile);
        assertEquals(content, result);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(testFile, "Sample text");
        assertTrue(Files.exists(Paths.get(testFile)));
    }

    @Test
    void testReadNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> processor.readFromFile("nonexistent.txt"));
    }
}
