import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder text = new StringBuilder();
        
        while ((line = reader.readLine()) != null) {
            text.append(line).append(" ");
        }
        
        String[] words = text.toString().split("\\s+");
        Map<String, Integer> frequency = new HashMap<>();
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        String mostFrequentWord = null;
        int maxFrequency = -1;
        
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            String word = entry.getKey();
            int currentFrequency = entry.getValue();
            
            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                mostFrequentWord = word;
            } else if (currentFrequency == maxFrequency) {
                if (word.compareTo(mostFrequentWord) < 0) {
                    mostFrequentWord = word;
                }
            }
        }
        
        System.out.println(mostFrequentWord);
    }
}