import java.util.regex.*;

public class SSNValidator {

    public static boolean isValidSSN(String ssn) {
        String pattern = "^\\d{3}-\\d{2}-\\d{4}$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(ssn);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] ssns = {"123-45-6789", "123456789", "987-65-4321"};

        for (String ssn : ssns) {
            if (isValidSSN(ssn)) {
                System.out.println('"' + ssn + "\" is valid");
            } else {
                System.out.println('"' + ssn + "\" is invalid");
            }
        }
    }
}
