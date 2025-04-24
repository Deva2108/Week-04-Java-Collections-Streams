class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

public class TransactionProcessor {

    public void processTransaction(int transactionId, double amount) throws TransactionException {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero.");
            }
            System.out.println("Processing transaction " + transactionId + " with amount: " + amount);

        } catch (IllegalArgumentException e) {
            throw new TransactionException("Transaction " + transactionId + " failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();
        
        try {
            processor.processTransaction(12345, -50.0); 
        } catch (TransactionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
