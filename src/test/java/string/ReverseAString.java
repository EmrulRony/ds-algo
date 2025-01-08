package string;

public class ReverseAString {

    public static String reverse(String input) {
        StringBuilder reversedString = new StringBuilder();
        int length = input.length();
        for (int i = length - 1; i >= 0; i--) {
            reversedString.append(input.charAt(i));
        }
        return reversedString.toString();
    }
    public static void main(String[] args) {
        String result = reverse("I love java");
        System.out.println(result);
    }
}
