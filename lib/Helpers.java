package lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import manager.Manager;
import model.Card;
import model.City;
import model.Faculty;
import model.Field;
import model.Member;

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

    public static void printAnyList(ArrayList<?> list, Manager manager) {
        if (list != null) {
            String className = list.get(0).getClass().getName();

            switch (className) {
                case "model.Member":
                    System.out.println(printTableTitle("LIST OF ACEM MEMBERS"));
                    System.out.print(
                            "\n  ID | \t   FULL NAME  \t  | AGE | PASSPORT  | MAT AMCI |   CIN    |   REASON    |    CITY    |      FORMATION       |   DIPLOMA   | FACULTY | ADHESION |       EMAIL       |\n ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n");
                    for (int i = 0; i < list.size(); i++) {

                        Member member = manager.getMember(i);

                        /* #### HACK TO HAVE AN AWESOME DISPLAY OF THE ARRAY IN THE CONSOLE */

                        // we used ternary for displayind id in the same column no matter how many
                        // digits it holds
                        String fullName = member.getFirstName() + " " + member.getLastName();

                        /* ### HACK ENDS */
                        System.out.println(printId(i, member.getId()) + " | " + formatString(fullName, 17) + "| "
                                + member.getAge() + "  | " + member.getPassport() + " | " + member.getMatriculeAmci()
                                + " | " +

                                (manager.getCard(member.getIdCard() - 1) != null
                                        ? manager.getCard(member.getIdCard() - 1).getCin()
                                        : "No Card!")
                                + " | " +

                                (manager.getCard(member.getIdCard() - 1) != null
                                        ? formatString(manager.getCard(member.getIdCard() - 1).getReason(), 10)
                                        : formatString("No Card!", 10))

                                + "| " + formatString(manager.getCity(member.getIdCity() - 1).getName(), 9) + "| "
                                + formatString(
                                        manager.getCity(member.getIdCity() - 1).getFaculty(member.getIdFaculty() - 1)
                                                .getField(member.getIdField() - 1).getAbbr(),
                                        19)

                                + "| "
                                + formatString(
                                        manager.getCity(member.getIdCity() - 1).getFaculty(member.getIdFaculty() - 1)
                                                .getField(member.getIdField() - 1).getCertificate(),
                                        10)
                                + "| "
                                + formatString((manager.getCity(member.getIdCity() - 1)
                                        .getFaculty(member.getIdFaculty() - 1).getAbbr()), 6)
                                +

                                "| "
                                + (member.getIsMember() == true ? (formatString("YES ", 6)) : (formatString("NO ", 6)))
                                + " | " + formatString(member.getEmail(), 16) + "|");
                        System.out.print(i < list.size() - 1
                                ? " ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n"
                                : "\n\n");
                    }
                    break;

                case "model.City":
                    System.out.println(printTableTitle("LIST OF CITIES"));
                    System.out.println("");
                    System.out.print(
                            "\n\t\t\t\t     ID |\tCITY       |\t\tREGION\t          |   \t\tFACULTIES\t\t |\n\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n");
                    for (int i = 0; i < list.size(); i++) {
                        City city = manager.getCity(i);
                        System.out.println("\t\t\t\t   " + printId(i, city.getId()) + " | "
                                + formatString(city.getName(), 14) + " | " + formatString(city.getRegion(),
                                        26)
                                + " | "
                                + city.getFacs().toString() + " \t");
                        System.out.print((i < list.size() - 1)
                                ? "\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n"
                                : "\n\n");
                    }

                    break;
                case "model.Faculty":
                    System.out.println(printTableTitle("LIST OF FACULTIES"));
                    System.out.print(
                            "\n\t\t     ID |    FACULTY    | \t\t\t\t\t\t\tFORMATIONS\t\t\t\t\t\t  |\n\t\t    ----|---------------|-----------------------------------------------------------------------------------------------------------------|\n");
                    for (int i = 0; i < list.size(); i++) {
                        Faculty fac = manager.getCity(i).getFacs().get(i);
                        System.out.println("\t\t   " + printId(i, fac.getId()) +
                                " | "
                                + formatString(fac.getAbbr(), 11) + " | "
                                + fac.getFields().toString());
                        // System.out.println("\t----|---------------|--------------------------------------------------------
                        // ----------------------------------------------------------");
                        System.out.print((i < list.size() - 1)
                                ? "\t\t    ----|---------------|-----------------------------------------------------------------------------------------------------------------|\n"
                                : "\n\n");
                    }
                    break;
                case "model.Card":
                    System.out.println(printTableTitle("LIST OF STAY CARDS"));
                    System.out.print(
                            "\n\t\t\t     ID | \tFULL NAME\t  | BIRTH DATE |   CIN    |  STAY REASON | OBTENTION DATE | EXPIRATION DATE |  PIN   | CITY\n\t\t\t    ----|-------------------------|------------|----------|--------------|----------------|-----------------|--------|------\n");
                    for (int i = 0; i < list.size(); i++) {
                        Card card = manager.getCard(i);
                        System.out.println("\t\t\t   " + printId(i, card.getId()) + " | "
                                + formatString(getMemberCard(card.getIdMember(), manager).getFirstName() + " "
                                        + getMemberCard(card.getIdMember(), manager).getLastName(), 21)
                                + " | " + getMemberCard(card.getIdMember(), manager).getBirthDate() + " | " +
                                card.getCin()
                                + " | " + formatString(card.getReason(), 10) + " | "
                                + formatString(card.getObtentionDate(), 12) + " | "
                                + formatString(card.getExpirationDate(), 13) + " | " + card.getPin() + "   | "
                                + formatString(findCityCardbyId(card.getIdCity(), manager).getName(), 13));
                        System.out.print((i < list.size() - 1)
                                ? "\t\t\t    ----|-------------------------|------------|----------|--------------|----------------|-----------------|--------|------\n"
                                : "\n\n");
                    }
                    break;

                default:
                    System.out.println("The fuck you trying to do though");
            }
        } else
            System.exit(0);
    }

    public static void printSingleMember(Manager manager, Member member, int i) {
        if(member == null) {
            System.out.println(printTableTitle("ERROR MEMBER NOT FOUND"));
            System.exit(0);
        }
        System.out.println(printTableTitle("MEMBER FOUND"));
        System.out.print(
                "\n  ID | \t   FULL NAME  \t  | AGE | PASSPORT  | MAT AMCI |   CIN    |   REASON    |    CITY    |      FORMATION       |   DIPLOMA   | FACULTY | ADHESION |       EMAIL       |\n ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n");

        /* #### HACK TO HAVE AN AWESOME DISPLAY OF THE ARRAY IN THE CONSOLE */

        // we used ternary for displayind id in the same column no matter how many
        // digits it holds
        String fullName = member.getFirstName() + " " + member.getLastName();

        /* ### HACK ENDS */
        System.out.println(printId(i, member.getId()) + " | " + formatString(fullName, 17) + "| "
                + member.getAge() + "  | " + member.getPassport() + " | " + member.getMatriculeAmci()
                + " | " +

                (manager.getCard(member.getIdCard() - 1) != null
                        ? manager.getCard(member.getIdCard() - 1).getCin()
                        : "No Card!")
                + " | " +

                (manager.getCard(member.getIdCard() - 1) != null
                        ? formatString(manager.getCard(member.getIdCard() - 1).getReason(), 10)
                        : formatString("No Card!", 10))

                + "| " + formatString(manager.getCity(member.getIdCity() - 1).getName(), 9) + "| "
                + formatString(
                        manager.getCity(member.getIdCity() - 1).getFaculty(member.getIdFaculty() - 1)
                                .getField(member.getIdField() - 1).getAbbr(),
                        19)

                + "| "
                + formatString(
                        manager.getCity(member.getIdCity() - 1).getFaculty(member.getIdFaculty() - 1)
                                .getField(member.getIdField() - 1).getCertificate(),
                        10)
                + "| "
                + formatString((manager.getCity(member.getIdCity() - 1)
                        .getFaculty(member.getIdFaculty() - 1).getAbbr()), 6)
                +

                "| "
                + (member.getIsMember() == true ? (formatString("YES ", 6)) : (formatString("NO ", 6)))
                + " | " + formatString(member.getEmail(), 16) + "|");
        System.out.print(
                " ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n");
    }

    public static void printFieldByFaculty(Manager manager, String abbr) {
        City cityMgr = manager.getCity(manager.getIdCity() - 1);
        for (Faculty faculty : cityMgr.getFacs()) {
            if (faculty.getAbbr().equalsIgnoreCase(abbr)) {

                System.out.println(printTableTitle(faculty.getAbbr() + ":  SAVED FIELDS"));
                System.out.print(
                        "\n\t\t\t\t\t\t  ID |    FIELD ABBR\t    | FIELD NAME\t\t\t       | CERTIFICATE      |  DURATION \t |\n\t\t\t\t\t\t ----|----------------------|------------------------------------------|------------------|--------------|\n");

                for (int i = 0; i < faculty.getFields().size(); i++) {
                    Field field = faculty.getField(i);
                    System.out.println("\t\t\t\t\t\t" + printId(i, field.getId()) +
                            " | "
                            + formatString(field.getAbbr(), 18) + " | "
                            + formatString(field.getName(), 38) + " | "
                            + formatString(field.getCertificate(), 12) + "   | " +
                            field.getDuration()
                            + "\t\t |");

                    System.out.print((i < faculty.getFields().size() - 1)
                            ? "\t\t\t\t\t\t ----|----------------------|------------------------------------------|------------------|--------------|\n"
                            : "\n\n");

                }
            }
        }
    }

    /*
     * FOREIGN KEY LOGIC IMPLEMENTATION
     * this helps with looking for data in foreign tables to print
     */
    public static Member getMemberCard(int idMember, Manager manager) {
        // Member member = new Member();
        for (Member member : manager.getMembers()) {
            if (idMember == member.getId())
                return member;
        }

        return null;
    }

    public static City findCityCardbyId(int idCity, Manager manager) {

        for (City city : manager.getCities()) {
            if (idCity == city.getId())
                return city;
        }
        return null;

    }

    /*
     * FOREIGN KEYS IMPLEMENTATION ENDS
     */

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
