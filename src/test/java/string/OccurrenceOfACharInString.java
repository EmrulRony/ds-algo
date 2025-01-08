package string;

public class OccurrenceOfACharInString {

    static int getOccurenceOfChar(String input, Character ch) {
        int count = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (ch.equals(input.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int result = getOccurenceOfChar("I love manchester united", 'd');
        System.out.println(result);
    }
}
