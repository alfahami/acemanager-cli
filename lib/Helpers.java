package lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import manager.Manager;
import model.Card;
import model.City;
import model.Member;

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

     public static void printAnyArrays(ArrayList<Object> arrays, Manager manager) {
        if (arrays != null) {
            String className = arrays.getClass().getCanonicalName();
            // switch array instance
            // String className = arrays[i].getClass().getName();
            switch (className) {
                case "ArrayList<Member>":
                    System.out.println(printTableTitle("LIST OF ACEM MEMBERS"));
                    System.out.print(
                            "\n  ID | \t   FULL NAME  \t  | AGE | PASSPORT  | MAT AMCI |   CIN    |   REASON   |    CITY    |      FORMATION       |   DIPLOMA   | FACULTY | ADHESION |       EMAIL       |\n ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n");
                    for (int i = 0; i < arrays.size(); i++) {

                        Member member = manager.getMember(i);

                        /* #### HACK TO HAVE AN AWESOME DISPLAY OF THE ARRAY IN THE CONSOLE */

                        // we used ternary for displayind id in the same column no matter how many
                        // digits it holds
                        String fullName = member.getFirstName() + " " + member.getLastName();

                        // THINK ABOUT USING STRINGBUILDER as it offers a set length, the idea would be
                        // to print all the Stringbuilder object and when no value found print space

                        /* ### HACK ENDS */
                        System.out.println(printId(i, member.getId()) + " | " + formatString(fullName, 17) + "| "
                                + member.getAge() + "  | " + member.getPassport() + " | " + member.getMatriculeAmci()
                                + " | " +

                                (manager.getCard(member.getIdCard() -1) != null ? manager.getCard(member.getIdCard()).getCin()
                                        : "No Card!")
                                + " | " +

                                (manager.getCard(member.getIdCard()) != null
                                        ? formatString(manager.getCard(member.getIdCard()).getReason(), 10)
                                        : formatString("No Card!", 10))

                                + "| " + formatString(manager.getCity(member.getIdCity() - 1).getName(), 9) + "| "
                                + formatString(manager.getCity(member.getIdCity() - 1).getFaculty(member.getIdFaculty() -1).getField(member.getIdField() - 1).getName(), 19)

                                + "| " + formatString(manager.getCity(member.getIdCity() - 1).getFaculty(member.getIdFaculty() -1).getField(member.getIdField() - 1).getCertificate(), 10)
                                + "| "
                                + formatString((manager.getCity(member.getIdCity() - 1).getFaculty(member.getIdFaculty() -1).getDesc()), 6) +

                                "| "
                                + (member.getIsMember() == true ? (formatString("YES ", 6)) : (formatString("NO ", 6)))
                                + " | " + formatString(member.getEmail(), 16) + "|");
                        System.out.print(i < arrays.size() - 1
                                ? " ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n"
                                : "\n\n");
                    }
                    break;
                /*    
                case "City[]":
                    System.out.println(printTableTitle("LIST OF CITIES"));
                    System.out.println("");
                    System.out.print(
                            "\n\t\t\t\t     ID |\tCITY       |\t\tREGION\t          |   \t\tFACULTIES\t\t |\n\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n");
                    for (int i = 0; i < arrays.length; i++) {
                        City city = manager.getCity(i);
                        System.out.println("\t\t\t\t   " + printId(i, city.getId()) + " | "
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
                    */
                default:
                    System.out.println("The fuck you trying to do though");
            }
        } else
            System.exit(0);
    }

    public static String formatString(String s, int i) {
        String space = " ";
        if (s.length() < i) {
            for (int j = 0; j <= i - s.length(); j++) {
                space += " ";
            }
        }
        return s + space;
    }

    public static String printId(int i, int id) {
        return (i < 9 ? ("  " + String.valueOf(id)) + " " : (" " + String.valueOf(id)) + " ");
    }

    public static String printTableTitle(String tTitle) {
        return "\n\t\t\t\t\t\t\t\t\t==========================\n\t\t\t\t\t\t\t\t\t\s\s\s" + tTitle
                + "\n\t\t\t\t\t\t\t\t\t==========================\n";
    }
}
