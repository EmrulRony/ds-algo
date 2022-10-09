package algoexpert.string.caeserCipherEncryptor;

public class Program {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        char resultChars[] = new char[str.length()];
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int newKey = key % 26;
        for (int i = 0; i < str.length(); i++) {
            resultChars[i] = getShiftedKChar(str.charAt(i), alphabets, key);
        }
        return new String(resultChars);
    }

    private static Character getShiftedKChar(char ch, String alphabets, int key) {
        int newIndex = alphabets.indexOf(ch) + key;
        return alphabets.charAt(newIndex);
    }
}

