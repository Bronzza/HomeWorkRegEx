package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilValidator {

    public static boolean emailValidator(String email) {
        String emailPattern = "^\\w+([.\\w]+)*\\w@\\w((.\\w)*\\w+)*\\.\\D{2,3}$";
        return checkPattern(emailPattern, email);
    }

    public static boolean phoneNumbValidator(String phoneNumber) {
        String phoneNumberPattern = "^[+]*\\d{0,2}[(]{0,1}\\d{0,4}[)]{0,1}[-\\s\\.\\d]{7,10}$";
        return checkPattern(phoneNumberPattern, phoneNumber);
    }

    public static boolean dateValidator(String expectedDate) {
        String pattern = "^[0123]{0,1}\\d{1}[-\\s\\.\\/]{1}[01]{0,1}\\d{1}[-\\s\\.\\/]{1}\\d{1,4}$";
        return checkPattern(pattern, expectedDate);
    }

    public static boolean ipValidator(String expectedIp) {
        String ipPattern = "^\\d{1,3}[.]{1}\\d{1,3}[.]{1}\\d{1,3}[.]{1}\\d{1,3}$";
        return checkPattern(ipPattern, expectedIp);
    }

    private static boolean checkPattern(String regExPattern, String stringToCheck) {
        Pattern pattern = Pattern.compile(regExPattern);
        Matcher matcher = pattern.matcher(stringToCheck);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
