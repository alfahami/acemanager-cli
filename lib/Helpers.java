package lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    // check Java 8 Docs for Date and SimpleFormat
    public static boolean validateDate(String date) throws ParseException {            
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
                sdf.parse(date);
                return true;
    }
}
