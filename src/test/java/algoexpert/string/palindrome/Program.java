package algoexpert.string.palindrome;

class Program {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        int leftPointer = 0;
        int rightPointer = str.length() - 1;
        while (leftPointer < rightPointer) {
            if (str.charAt(leftPointer) != str.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}


