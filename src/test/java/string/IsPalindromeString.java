package string;

public class IsPalindromeString {

    public static boolean isPalindrome(String input) {
        StringBuilder reversedString = new StringBuilder();
        int length = input.length();
        for (int i = length - 1; i >= 0; i--) {
            reversedString.append(input.charAt(i));
        }
        return reversedString.toString().equals(input);
    }
    public static void main(String[] args) {
        boolean result = isPalindrome("abba");
        System.out.println(result);
    }
}
