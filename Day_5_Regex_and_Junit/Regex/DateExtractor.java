import java.util.*;
import java.util.regex.*;

public class DateExtractor {

    public static List<String> extractDates(String text) {
        String pattern = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        Pattern compiledPattern = Pattern.compile(pattern);

        Matcher matcher = compiledPattern.matcher(text);

        List<String> dates = new ArrayList<>();

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        List<String> dates = extractDates(text);

        for (String date : dates) {
            System.out.println(date);
        }
    }
}
