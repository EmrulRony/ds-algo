package string;

import java.util.Arrays;

public class IsAnagram {

    // O (n long n)
    static boolean checkForAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] str1Chars = str1.toCharArray();
        char[] str2chars = str2.toCharArray();
        Arrays.sort(str1Chars);
        Arrays.sort(str2chars);
        return Arrays.equals(str1Chars, str2chars);
    }

    private static final int CHARACTER_RANGE = 256;

    // O(n)
    static boolean checkForAnagramOptimized(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = checkForAnagram("!low-salt!", "owls-lat!!");
        System.out.println(result);

        boolean resultOptimized = checkForAnagramOptimized("!low-salt!", "owls-lat!!");
        System.out.println(resultOptimized);
    }
}
