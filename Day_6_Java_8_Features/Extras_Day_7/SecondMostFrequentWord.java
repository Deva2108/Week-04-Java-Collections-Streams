import java.util.*;
import java.util.stream.Collectors;

public class SecondMostFrequentWord {
    public static void main(String[] args) {
        String text = "apple banana apple banana orange apple banana apple apple";
        String[] words = text.split("\\s+");

        Map<String, Long> wordCount = Arrays.stream(words)
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<Map.Entry<String, Long>> sortedEntries = wordCount.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .collect(Collectors.toList());

        if (sortedEntries.size() >= 2) {
            System.out.println("Second most frequent word: " + sortedEntries.get(1).getKey());
        } else {
            System.out.println("There is no second most frequent word.");
        }
    }
}
