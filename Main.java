import static lib.Helpers.*;

import java.util.ArrayList;
import java.util.Scanner;

import static constants.FillTables.*;
import constants.Role;
import lib.Helpers;
import manager.Manager;
import manager.SuperUser;
import model.City;
import model.Faculty;
import model.Field;
import model.Member;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        SuperUser root = new SuperUser();
        root.setSession_start();
        System.out.println("\n\t\t\t\t\t\t\t\t\tRoot session start: " + root.getSession_start());
        ArrayList<Field> fields = fillFieldsFs();
        ArrayList<Faculty> facs = fillFaculties(fields);
        root.addCities(fillCities(facs));
        ArrayList<Member> baseMembers = fillMembers();
        root.addMembers(baseMembers);
        root.addCards(fillCards());

        

       // root.addMember(member);
        //printAnyList(root.getMembers(), root);
        root.setSession_end();
        System.out.println("\n\t\t\t\t\t\t\t\t\tRoot session start: " + root.getSession_end());

        scan.close();

    }

    public static int promptForMenu(Scanner scanner) {
        System.out.println("\n\t\t\t\t\t\t\t\t\t===========================\n\n" +
                "\t\t\t\t\t\t\t\t\t\s  Welcome to ACEMANAGER\n"
                + "\t\t\t\t\t\t\t\t\s  An association membership management\n\n" +
                "\t\t\t\t\t\t\t\t\t===========================\n");
        while(true) {
            System.out.print(
                "\n\t\t\t\t\t\t\t\t\tWhat would you like to do?\n\n\t\t\t\t\t\t\t\t\t1. List Members\n\t\t\t\t\t\t\t\t\t2. Add a new member\n\t\t\t\t\t\t\t\t\t3. Update a member\n\t\t\t\t\t\t\t\t\t4. Delete a member\n\t\t\t\t\t\t\t\t\t5. Exit\n\t\t\t\t\t\t\t\t\tPlease choose an option: ");
            if(!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            if(choice <= 0 || choice > 5) continue;
            return choice; 
        }  
    }

    public static void processChoice(int choice, Scanner scan, ArrayList<?> list, Manager manager) {
        switch (choice) {
            case 1:
                printAnyList(list, manager);
                break;
            case 2:
                scan.nextLine();
                Member newMember = createMember(scan);
                manager.addMember(newMember);
                printAnyList(manager.getMembers(), manager);
            default:
                break;
        }
    }

    public static Member createMember(Scanner scan) {
        String fname = promptForFirstName(scan);
        String lname = promptForLastName(scan);
        String passport = promptForPassport(scan);
        int matAmci = promptForMatAmci(scan);
        String birthDate = promptForBirthDate(scan);
        String email = promptForEmail(scan);
        boolean isMember = promptForMemberStatus(scan);

        Member member = new Member(0, fname, lname, birthDate, email, passport, matAmci, 2, 2, 2, 2, isMember);

        return member;
    }

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

    public static Field createField(Scanner scan) {
        String abbr = promptForFieldAbbr(scan);
        String name = promptForFieldName(scan);
        String certificate = promptForCertificate(scan);
        int duration = promptForDuration(scan);

        return new Field(1, abbr, name, certificate, duration);
    }

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
        return (mat <= 0 || String.valueOf(mat).length() != 8);
    }

    public static boolean isInvalidPassport(String input) {
        return (input.length() != 9);
    }

    public static boolean isInvalidDuration(int input) {
        return (input < 0 || input >= 5);
    }

}