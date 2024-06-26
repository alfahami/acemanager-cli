package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    // prefer java.time over SimpleFormat
    public static boolean isValidDateFormat(String format, String value) {
        try {
            LocalDate.parse(value, DateTimeFormatter.ofPattern(format));
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }

    // Crashing the app if the date is in the wrong format
    public static void setDateException(String date) {
        if (date == null || date.isBlank())
            throw new IllegalArgumentException("Birth date cannot be null or blank. ");
        if (!isValidDateFormat("dd/MM/yyyy", date))
            throw new IllegalArgumentException("Invalid date format: date format must strictly follow \"dd/MM/yyyy\"");
    }

}
