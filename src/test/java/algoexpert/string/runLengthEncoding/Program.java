package algoexpert.string.runLengthEncoding;

public class Program {
    public String runLengthEncoding(String string) {
        StringBuilder result = new StringBuilder();
        int lengthCount = 1;
        for (int i = 1; i < string.length(); i++) {
            Character current = string.charAt(i);
            Character prev = string.charAt(i - 1);
            if (current != prev || lengthCount == 9) {
                result.append(Integer.valueOf(lengthCount));
                result.append(prev);
                lengthCount = 0;
            }
            lengthCount++;
        }
        result.append(Integer.valueOf(lengthCount));
        result.append(string.charAt(string.length() - 1));
        return result.toString();
    }
}

