class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}

public class DataProcessor {

    public void processData(int value) throws CustomCheckedException {
        if (value < 0) {
            throw new CustomCheckedException("Checked exception: Negative value not allowed.");
        } else if (value == 0) {
            throw new ArithmeticException("Unchecked exception: Cannot process zero.");
        } else {
            System.out.println("Data processed successfully with value: " + value);
        }
    }

    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();

        try {
            processor.processData(-1);  
        } catch (CustomCheckedException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        try {
            processor.processData(0); 
        } catch (ArithmeticException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }
    }
}
