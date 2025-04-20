

import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> freq = new HashMap<>();
        for (String item : items) {
            if (!freq.containsKey(item)) {
                freq.put(item, 1);
            } else {
                freq.put(item, freq.get(item) + 1);
            }
        }
        System.out.println(freq);
    }
}