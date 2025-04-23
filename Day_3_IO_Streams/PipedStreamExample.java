import java.io.*;

public class PipedStreamExample {

    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(() -> {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
                    writer.write("Hello from Writer Thread!");
                    writer.flush();
                } catch (IOException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });

            Thread readerThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
                    String message = reader.readLine();
                    System.out.println("Reader received: " + message);
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Pipe error: " + e.getMessage());
        }
    }
}
