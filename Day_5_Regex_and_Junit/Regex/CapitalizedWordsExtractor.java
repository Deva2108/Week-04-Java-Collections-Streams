import java.util.regex.*;
import java.util.*;

public class CapitalizedWordsExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        String pattern = "\\b[A-Z][a-z]*\\b";

        Pattern compiledPattern = Pattern.compile(pattern);

        Matcher matcher = compiledPattern.matcher(text);

        List<String> capitalizedWords = new ArrayList<>();

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> capitalizedWords = extractCapitalizedWords(text);

        for (String word : capitalizedWords) {
            System.out.println(word);
        }
    }
}
