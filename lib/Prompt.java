package lib;

import java.util.Scanner;

import model.Faculty;
import static lib.Helpers.*;
import static constants.FillTables.*;


public class Prompt {
    
    /*
     * PROMPT FOR CREATING A MEMBER
     * 
     */
    public static String promptForFirstName(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter member's firstname: ");
            String firstname = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(firstname))
                return firstname;
        }
    }

    public static String promptForLastName(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter member's lastname: ");
            String lastname = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(lastname))
                return lastname;
        }
    }

    public static String promptForPassport(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter member's passport: ");
            String passport = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(passport) && !isInvalidPassport(passport))
                return passport;
        }
    }

    public static String promptForBirthDate(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter member's birth date: ");
            String birthdate = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(birthdate) && isValidDateFormat("dd/MM/yyyy", birthdate))
                return birthdate;
        }
    }

    public static int promptForMatAmci(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter member's AMCI identifier: ");
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            int matAmci = scanner.nextInt();
            if (!isInvalidMatAmci(matAmci)) {
                scanner.nextLine(); // nextLine trap
                return matAmci;
            }
        }
    }

    public static String promptForEmail(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter member's email: ");
            String email = scanner.nextLine();
            if (!isNullOrBlank(email) && validateEmail(email))
                return email;
        }
    }

    public static boolean promptForMemberStatus(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tIs the member already an adherant - Yes|No- : ");
            String status = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(status))
                return status.equalsIgnoreCase("yes");

        }
    }

    public static Faculty createFaculty(Scanner scan) {
        String abbr = promptForFacAbbr(scan);
        String name = promptForFacName(scan);

        return new Faculty(1, abbr, name, fillFieldsFs());
    }

    public static String promptForFacAbbr(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter faculty nitials (abbreviation): ");
            String abbr = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(abbr)) return abbr;
        } 
    }

    public static String promptForFacName(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter faculty's name : ");
            String name = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(name)) return name;

        }
    }

    /*
     * PROMPT FOR CREATING A CARD
     */
    public static String promptForCin(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter CIN identifier : ");
            String cin = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(cin) && !isInvalidCin(cin)) return cin;
        } 
    }

    public static String promptForReason(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter CIN's reason : ");
            String reason = scanner.nextLine();
            if (!isNullOrBlank(reason)) return reason;
        } 
    }

    public static String promptForObtentionDate(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter CIN's obtention date : ");
            String obtDate = scanner.nextLine();
            if (!isNullOrBlank(obtDate) && isValidDateFormat("dd/MM/yyyy", obtDate)) return obtDate;
        } 
    }

    public static String promptForExpirationDate(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter CIN's expiration date : ");
            String expDate = scanner.nextLine();
            if (!isNullOrBlank(expDate) && isValidDateFormat("dd/MM/yyyy", expDate)) return expDate;
        } 
    }

    public static int promptForPin(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter CIN's secret pin : ");
            if(!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            int pin = scanner.nextInt();
            if (!isInvalidPin(pin)) return pin;
        } 
    }


    /*
     * PROMPT FOR CREATING A FIELD
     * 
     */
    public static String promptForFieldAbbr(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter field nitials (abbreviation): ");
            String abbr = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(abbr)) return abbr;
        } 
    }

    public static String promptForFieldName(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter field name : ");
            String name = scanner.nextLine().toUpperCase();
            if (!isNullOrBlank(name)) return name;
        } 
    }

    public static String promptForCertificate(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter field certificate : ");
            String certificate = scanner.nextLine();
            if (!isNullOrBlank(certificate)) return certificate;
        } 
    }

    public static int promptForDuration(Scanner scanner) {
        while (true) {
            System.out.print("\n\t\t\t\t\t\t\t\t\t\tEnter field's duration : ");
            if(!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            int duration = scanner.nextInt();
            if(!isInvalidDuration(duration)) return duration;
        } 
    }

    public static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean isInvalidMatAmci(int mat) {
        return mat <= 0 || String.valueOf(mat).length() != 8;
    }

    public static boolean isInvalidPassport(String input) {
        return input.length() != 9;
    }

    public static boolean isInvalidDuration(int input) {
        return input < 0 || input >= 5;
    }

    public static boolean isInvalidPin(int input) {
        return input <= 0 || String.valueOf(input).length() != 4;
    }

    public static boolean isInvalidCin(String cin) {
        return cin.length() != 8;
    }
}
