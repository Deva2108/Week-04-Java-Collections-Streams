import java.io.*;
import java.util.Arrays;

public class ImageByteArray {
    public static void main(String[] args) {
        String inputImage = "input.jpg";
        String outputImage = "output.jpg";

        try (FileInputStream fis = new FileInputStream(inputImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(outputImage)) {

                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

                System.out.println("Image copied using byte array streams.");
            }

            if (compareFiles(inputImage, outputImage)) {
                System.out.println("The files are identical.");
            } else {
                System.out.println("The files are not identical.");
            }

        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }

    private static boolean compareFiles(String file1, String file2) {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            byte[] b1 = fis1.readAllBytes();
            byte[] b2 = fis2.readAllBytes();

            return Arrays.equals(b1, b2);
        } catch (IOException e) {
            System.out.println("Comparison error: " + e.getMessage());
            return false;
        }
    }
}
