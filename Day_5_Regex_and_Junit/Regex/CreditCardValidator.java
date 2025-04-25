import java.util.regex.*;

public class CreditCardValidator {

    public static boolean isValidCreditCard(String cardNumber) {
        String visaPattern = "^4\\d{15}$"; 
        String masterCardPattern = "^5\\d{15}$"; 

        return cardNumber.matches(visaPattern) || cardNumber.matches(masterCardPattern);
    }

    public static void main(String[] args) {
        String[] cardNumbers = {"4111111111111111", "5111111111111111", "1234567890123456", "511234567890123"};

        for (String cardNumber : cardNumbers) {
            if (isValidCreditCard(cardNumber)) {
                System.out.println(cardNumber + " → Valid");
            } else {
                System.out.println(cardNumber + " → Invalid");
            }
        }
    }
}
