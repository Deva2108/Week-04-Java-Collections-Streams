import org.example.DateFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() throws ParseException {
        assertEquals("25-12-2023", formatter.formatDate("2023-12-25"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(ParseException.class, () -> formatter.formatDate("25/12/2023"));
    }

    @Test
    void testEmptyDate() {
        assertThrows(ParseException.class, () -> formatter.formatDate(""));
    }
}
