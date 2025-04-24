import java.io.*;
import java.util.List;

public class FileProcessor {

    public void processFiles(List<String> filePaths) {
        for (String filePath : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file " + filePath + ": " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        processor.processFiles(List.of("file1.txt", "file2.txt", "file3.txt"));
    }
}
