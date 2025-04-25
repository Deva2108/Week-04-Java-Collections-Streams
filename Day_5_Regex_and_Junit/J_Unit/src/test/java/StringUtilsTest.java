import static org.junit.jupiter.api.Assertions.*;

import org.example.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    StringUtils utils = new StringUtils();

    @Test
    public void testReverse() {
        assertEquals("cba", utils.reverse("abc"));
        assertEquals("racecar", utils.reverse("racecar"));
        assertNull(utils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(utils.isPalindrome("racecar"));
        assertTrue(utils.isPalindrome("Madam"));
        assertFalse(utils.isPalindrome("hello"));
        assertFalse(utils.isPalindrome(null));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("JAVA", utils.toUpperCase("java"));
        assertNull(utils.toUpperCase(null));
    }
}
