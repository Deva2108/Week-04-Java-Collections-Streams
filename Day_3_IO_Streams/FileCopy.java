import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "src.txt";
        String destFile = "dst.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(destFile);

            int byteContent;
            while ((byteContent = fis.read()) != -1) {
                fos.write(byteContent);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
