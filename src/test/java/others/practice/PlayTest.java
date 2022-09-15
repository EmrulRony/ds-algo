package others.practice;

import org.apache.commons.lang3.StringUtils;

public class PlayTest {
    public static void main(String[] args) {
        String fileName = "qwertesttesttesttesttesttesttesttesttesttest-testtesttesttesttesttesttest-testtesttest-testtesttest-testtesttest-testtesttest-testtesttetesttesttesttesttesttesttesttesttesttestetsteeeeewewewewe11.jpeg";
        String URL = "https://app.ideascale.com/userimages/avatar/582/5825315/" + fileName;
        int lenDiff = URL.length() - 254;
        System.out.println(fileName.length());
        if (lenDiff > 0) {
            String substring = StringUtils.substring(fileName, lenDiff);
            System.out.println(substring);
            System.out.println(substring.length());
            System.out.println("https://app.ideascale.com/userimages/avatar/582/5825315/" + substring);
        }
    }
}
