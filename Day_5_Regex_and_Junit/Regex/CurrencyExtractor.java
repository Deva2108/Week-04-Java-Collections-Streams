import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {

    public static List<String> extractCurrencies(String text) {
        String pattern = "\\$\\d+(\\.\\d{2})?|\\d+(\\.\\d{2})?";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        List<String> currencies = new ArrayList<>();

        while (matcher.find()) {
            currencies.add(matcher.group());
        }

        return currencies;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        List<String> currencies = extractCurrencies(text);

        for (String currency : currencies) {
            System.out.print(currency + ", ");
        }
    }
}
