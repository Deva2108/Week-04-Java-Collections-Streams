import java.io.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";

        long startBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
        }
        long endBuffered = System.nanoTime();

        long startUnbuffered = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destUnbuffered)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
        }
        long endUnbuffered = System.nanoTime();

        System.out.println("Buffered Stream Time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");
        System.out.println("Unbuffered Stream Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
    }
}
