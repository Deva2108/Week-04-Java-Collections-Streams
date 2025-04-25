import java.util.*;

public class BadWordCensorship {

    public static String censorBadWords(String sentence, List<String> badWords) {
        for (String badWord : badWords) {
            sentence = sentence.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }
        return sentence;
    }

    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");

        String censoredSentence = censorBadWords(sentence, badWords);

        System.out.println(censoredSentence);
    }
}
