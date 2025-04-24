public class DivisionProcessor {

    public static void performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        int result = numerator / denominator;
        System.out.println("Result: " + result);
    }

    public static void calculate(int numerator, int denominator) {
        try {
            performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error while performing division: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            calculate(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
