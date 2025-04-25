import java.util.regex.*;
import java.util.*;

public class RepeatingWordsFinder {

    public static List<String> findRepeatingWords(String sentence) {
        String pattern = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(sentence);
        Set<String> repeatingWords = new HashSet<>();

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }

        return new ArrayList<>(repeatingWords);
    }

    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";

        List<String> repeatingWords = findRepeatingWords(sentence);

        for (String word : repeatingWords) {
            System.out.print(word + ", ");
        }
    }
}
