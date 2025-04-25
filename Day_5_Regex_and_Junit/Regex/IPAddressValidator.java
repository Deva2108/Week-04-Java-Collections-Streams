import java.util.regex.*;

public class IPAddressValidator {

    public static boolean isValidIP(String ip) {
        String pattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] ipAddresses = {"192.168.1.1", "255.255.255.255", "256.100.50.25", "123.45.678.90"};

        for (String ip : ipAddresses) {
            if (isValidIP(ip)) {
                System.out.println(ip + " → Valid");
            } else {
                System.out.println(ip + " → Invalid");
            }
        }
    }
}
