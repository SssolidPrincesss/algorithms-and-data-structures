import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findSubstringInWraproundString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || (s.charAt(i - 1) == 'z' && s.charAt(i) == 'a'))) {
                maxLength++;
            } else {
                maxLength = 1;
            }
            char currentChar = s.charAt(i);
            count.put(currentChar, Math.max(count.getOrDefault(currentChar, 0), maxLength));
        }

        int result = 0;
        for (int value : count.values()) {
            result += value;
        }
        return result;
    }
}