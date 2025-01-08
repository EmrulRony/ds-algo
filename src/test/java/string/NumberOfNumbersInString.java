package string;

public class NumberOfNumbersInString {

    static int getNumberOccurrence(String input) {
        int result = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(input.charAt(i))) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = getNumberOccurrence("My password is 1234");
        System.out.println(result);
    }
}
