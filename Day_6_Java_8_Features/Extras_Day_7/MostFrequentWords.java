import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentWords {
    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("text_corpus.txt")), StandardCharsets.UTF_8);
        String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        Map<String, Long> wordCount = Arrays.stream(words)
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        wordCount.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .limit(10)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
