package by.sasnouski.array.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidString(String string) {
        boolean isValid = true;

        Pattern p = Pattern.compile("[^\\d\\s.-]");
        Matcher m = p.matcher(string);
        if (m.find()) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidNumber(String string) {

        return string.matches ("-?\\d+(\\.\\d+)?");
    }
}