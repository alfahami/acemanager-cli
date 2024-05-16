package lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.City;

public class Helpers {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    // prefer java.time over SimpleFormat    
    public static boolean isValidDateFormat(String format, String value) {
        try {
            LocalDate.parse(value, DateTimeFormatter.ofPattern(format));
            return true;
        } catch ( DateTimeParseException ex) {
            throw new IllegalArgumentException("Invalid date format: date format must strictly follow \"dd/MM/yyyy\"");
        }
    }

     public static void printAnyArrays(Object[] arrays) {
        if (arrays != null) {
            String className = arrays.getClass().getCanonicalName();
            // switch array instance
            // String className = arrays[i].getClass().getName();
            switch (className) {
                case "Member[]":
                    System.out.println(printTableTitle("LIST OF ACEM MEMBERS"));
                    System.out.print(
                            "\n  ID | \t   FULL NAME  \t  | AGE | PASSPORT  | MAT AMCI |   CIN    |   PATTERN   |    CITY    |      FORMATION       |   DIPLOMA   | FACULTY | ADHESION |       EMAIL       |\n ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n");
                    for (int i = 0; i < arrays.length; i++) {

                        Member member = getMember(i);

                        /* #### HACK TO HAVE AN AWESOME DISPLAY OF THE ARRAY IN THE CONSOLE */

                        // we used ternary for displayind id in the same column no matter how many
                        // digits it holds
                        String fullName = member.getFirstName() + " " + member.getLastName();

                        // THINK ABOUT USING STRINGBUILDER as it offers a set length, the idea would be
                        // to print all the Stringbuilder object and when no value found print space

                        /* ### HACK ENDS */
                        System.out.println(printId(i, member.getIdMember()) + " | " + formatString(fullName, 17) + "| "
                                + member.getAge() + "  | " + member.getPassport() + " | " + member.getMatriculeAmci()
                                + " | " +

                                (getCardById(member.getIdCard()) != null ? getCardById(member.getIdCard()).getCardNum()
                                        : "No Card!")
                                + " | " +

                                (getCardById(member.getIdCard()) != null
                                        ? formatString(getCardById(member.getIdCard()).getPattern(), 10)
                                        : formatString("No Card!", 10))

                                + "| " + formatString(getCityName(member.getIdCity()), 9) + "| "
                                + formatString(getFormationMember(member.getIdFormation()).getName(), 19)

                                + "| " + formatString(getFormationMember(member.getIdFormation()).getFCertificate(), 10)
                                + "| "
                                + formatString(getMemberFaculty(member.getIdFacultyInstitute()).getNameFacInst(), 6) +

                                "| "
                                + (member.isMember() == true ? (formatString("YES ", 6)) : (formatString("NO ", 6)))
                                + " | " + formatString(getMember(i).getEmail(), 16) + "|");
                        System.out.print(i < arrays.length - 1
                                ? " ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n"
                                : "\n\n");
                    }
                    break;
                case "City[]":
                    System.out.println(printTableTitle("LIST OF CITIES"));
                    System.out.println("");
                    System.out.print(
                            "\n\t\t\t\t     ID |\tCITY       |\t\tREGION\t          |   \t\tFACULTIES\t\t |\n\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n");
                    for (int i = 0; i < arrays.length; i++) {
                        City city = this.getCity(i);
                        System.out.println("\t\t\t\t   " + printId(i, city.getIdCity()) + " | "
                                + formatString(city.getName(), 14) + " | " + formatString(city.getRegion(), 26) + " | "
                                + Arrays.toString(city.getFacultyName()) + "  |");
                        System.out.print((i < arrays.length - 1)
                                ? "\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n"
                                : "\n\n");
                    }
                    break;
                case "Formation[]":
                    System.out.println(printTableTitle("LIST OF FORMATIONS"));
                    System.out.print(
                            "\n\t\t\t\t\t\t  ID |    FORMATION NAME    | CERTIFICATE    |  DURATION \t  |\n\t\t\t\t\t\t ----|----------------------|----------------|--------------------|\n");
                    for (int i = 0; i < arrays.length; i++) {
                        Formation formation = getFormation(i);
                        System.out.println("\t\t\t\t\t\t" + printId(i, formation.getIdFormation()) + " | "
                                + formatString(formation.getName(), 18) + " | "
                                + formatString(formation.getFCertificate(), 12) + " | " + formation.getDuration()
                                + "\t\t  |");
                        System.out.print((i < arrays.length - 1)
                                ? "\t\t\t\t\t\t ----|----------------------|----------------|--------------------|\n"
                                : "\n\n");
                    }
                    break;
                case "FacultyInstitute[]":
                    System.out.println(printTableTitle("LIST OF FACULTIES"));
                    System.out.print(
                            "\n\t\t     ID |    FACULTY    | \t\t\t\t\t\t\tFORMATIONS\t\t\t\t\t\t  |\n\t\t    ----|---------------|-----------------------------------------------------------------------------------------------------------------|\n");
                    for (int i = 0; i < arrays.length; i++) {
                        FacultyInstitute fac = getFacultyInstitute(i);
                        System.out.println("\t\t   " + printId(i, fac.getIdFacultyInstitute()) + " | "
                                + formatString(fac.getNameFacInst(), 11) + " | "
                                + Arrays.toString(fac.getFormationNames()) + " |");
                        // System.out.println("\t
                        // ----|---------------|------------------------------------------------------------------------------------------------------------------");
                        System.out.print((i < arrays.length - 1)
                                ? "\t\t    ----|---------------|-----------------------------------------------------------------------------------------------------------------|\n"
                                : "\n\n");
                    }
                    break;
                case "Card[]":
                    System.out.println(printTableTitle("LIST OF STAY CARDS"));
                    System.out.print(
                            "\n\t\t\t     ID | \tFULL NAME\t  | BIRTH DATE |   CIN    |  STAY REASON | OBTENTION DATE | EXPIRATION DATE |  PIN   |\n\t\t\t    ----|-------------------------|------------|----------|--------------|----------------|-----------------|--------|\n");
                    for (int i = 0; i < arrays.length; i++) {
                        Card card = getCard(i);
                        System.out.println("\t\t\t   " + printId(i, card.getIdCard()) + " | "
                                + formatString(getMemberCard(card.getIdMember()).getFirstName() + " "
                                        + getMemberCard(card.getIdMember()).getLastName(), 21)
                                + " | " + getMemberCard(card.getIdMember()).getBirthDate() + " | " + card.getCardNum()
                                + " | " + formatString(card.getPattern(), 10) + " | "
                                + formatString(card.getObtentionDate(), 12) + " | "
                                + formatString(card.getExpirationDate(), 13) + " | " + card.getPin() + " |");
                        System.out.print((i < arrays.length - 1)
                                ? "\t\t\t    ----|-------------------------|------------|----------|--------------|----------------|-----------------|--------|\n"
                                : "\n\n");
                    }
                    break;
                default:
                    System.out.println("The fuck you trying to do though");
            }
        } else
            System.exit(0);
    }
}
