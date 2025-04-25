import java.util.regex.*;
import java.util.*;

public class ProgrammingLanguageExtractor {

    public static List<String> extractLanguages(String text) {
        String pattern = "\\b(Java|Python|JavaScript|Go)\\b";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);

        List<String> languages = new ArrayList<>();

        while (matcher.find()) {
            languages.add(matcher.group());
        }

        return languages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> languages = extractLanguages(text);

        for (String language : languages) {
            System.out.print(language + ", ");
        }
    }
}
