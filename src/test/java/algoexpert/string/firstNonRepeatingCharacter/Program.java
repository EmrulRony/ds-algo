package algoexpert.string.firstNonRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;

class Program {

    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            charCountMap.put(string.charAt(i), charCountMap.getOrDefault(string.charAt(i), 0) + 1);
        }
        for (int i = 0; i < string.length(); i++) {
            if (charCountMap.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}