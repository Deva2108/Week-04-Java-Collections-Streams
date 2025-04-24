public class ResourceManager {

    public void manageConnection() {
        try (Connection connection = new Connection()) {
            System.out.println("Connection established.");
            if (true) {
                throw new Exception("Simulated exception during connection.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ResourceManager manager = new ResourceManager();
        manager.manageConnection();
    }
}

class Connection implements AutoCloseable {

    public Connection() {
        System.out.println("Opening connection...");
    }

    @Override
    public void close() {
        System.out.println("Closing connection and cleaning up resources.");
    }
}
