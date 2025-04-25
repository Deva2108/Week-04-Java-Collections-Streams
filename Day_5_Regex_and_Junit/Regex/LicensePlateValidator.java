import java.util.regex.*;

public class LicensePlateValidator {

    public static boolean isValidLicensePlate(String licensePlate) {
        String pattern = "^[A-Z]{2}\\d{4}$";

        Pattern compiledPattern = Pattern.compile(pattern);

        Matcher matcher = compiledPattern.matcher(licensePlate);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testPlates = {"AB1234", "A12345", "XY5678", "abc1234", "ZZ9999"};

        for (String plate : testPlates) {
            if (isValidLicensePlate(plate)) {
                System.out.println(plate + " → Valid");
            } else {
                System.out.println(plate + " → Invalid");
            }
        }
    }
}
