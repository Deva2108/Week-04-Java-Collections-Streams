import java.util.regex.*;

public class UsernameValidator {

    public static boolean isValidUsername(String username) {
        String pattern = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        Pattern compiledPattern = Pattern.compile(pattern);

        Matcher matcher = compiledPattern.matcher(username);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testUsernames = {"user_123", "123user", "us", "valid_User123", "_invalid", "a"};

        for (String username : testUsernames) {
            if (isValidUsername(username)) {
                System.out.println(username + " → Valid");
            } else {
                System.out.println(username + " → Invalid");
            }
        }
    }
}
