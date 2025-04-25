import java.util.regex.*;

public class HexColorValidator {

    public static boolean isValidHexColor(String hexColor) {
        String pattern = "^#[0-9A-Fa-f]{6}$";

        Pattern compiledPattern = Pattern.compile(pattern);

        Matcher matcher = compiledPattern.matcher(hexColor);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testColors = {"#FFA500", "#ff4500", "#123", "#ABCDEF", "#aabbcc"};

        for (String color : testColors) {
            if (isValidHexColor(color)) {
                System.out.println(color + " → Valid");
            } else {
                System.out.println(color + " → Invalid");
            }
        }
    }
}
