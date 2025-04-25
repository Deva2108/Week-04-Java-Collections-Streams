import java.util.regex.*;
import java.util.*;

public class LinkExtractor {

    public static List<String> extractLinks(String text) {
        String pattern = "\\bhttps?://[a-zA-Z0-9.-]+(?:/[a-zA-Z0-9&%_.-]*)?\\b";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        List<String> links = new ArrayList<>();

        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = extractLinks(text);

        for (String link : links) {
            System.out.println(link);
        }
    }
}
