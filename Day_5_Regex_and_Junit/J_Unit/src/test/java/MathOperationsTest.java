import static org.junit.jupiter.api.Assertions.*;

import org.example.MathOperations;
import org.junit.jupiter.api.Test;

public class MathOperationsTest {

    MathOperations math = new MathOperations();

    @Test
    public void testDivide() {
        assertEquals(2, math.divide(10, 5));
    }

    @Test
    public void testDivideByZero() {
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> {
            math.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", ex.getMessage());
    }
}
