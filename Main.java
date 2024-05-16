import static lib.Helpers.*;

import java.util.ArrayList;
import java.util.Scanner;

import constants.FillTables;
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
        System.out.println("Root session start: " + root.getSession_start());
        ArrayList<Field> fields = FillTables.fillFieldsFs();
        ArrayList<Faculty> facs = FillTables.fillFaculties(fields);
        root.addCities(FillTables.fillCities(facs));
        ArrayList<Member> baseMembers = FillTables.fillMembers();
        root.addMembers(baseMembers);
        root.addCards(FillTables.fillCards());

        String fname = promptForFirstName(scan);
        String lname = promptForLastName(scan);
        String passport = promptForPassport(scan);
        int matAmci = promptForMatAmci(scan);
        String birthDate = promptForBirthDate(scan);
        String email = promptForEmail(scan);
        boolean isMember = promptForMemberStatus(scan);

        Member member = new Member(0, fname, lname, birthDate, email, passport, matAmci, 2, 2, 2, 2, isMember);

        root.addMember(member);
        printAnyList(root.getMembers(), root);

    }

    public static String promptForFirstName(Scanner scanner) {
        while (true) {
            System.out.print("Enter member's firstname: ");
            String firstname = scanner.nextLine();
            if (!isNullOrBlank(firstname))
                return firstname;
        }
    }

    public static String promptForLastName(Scanner scanner) {
        while (true) {
            System.out.print("Enter member's lastname: ");
            String lastname = scanner.nextLine();
            if (!isNullOrBlank(lastname))
                return lastname;
        }
    }

    public static String promptForPassport(Scanner scanner) {
        while (true) {
            System.out.print("Enter member's passport: ");
            String passport = scanner.nextLine();
            if (!isNullOrBlank(passport) && !isInvalidPassport(passport))
                return passport;
        }
    }

    public static String promptForBirthDate(Scanner scanner) {
        while (true) {
            System.out.print("Enter member's birth date: ");
            String birthdate = scanner.nextLine();
            if (!isNullOrBlank(birthdate))
                return birthdate;
        }
    }

    public static int promptForMatAmci(Scanner scanner) {
        while (true) {
            System.out.print("Enter member's AMCI identifier: ");
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
            System.out.print("Enter member's email: ");
            String email = scanner.nextLine();
            if (!isNullOrBlank(email) && validateEmail(email))
                return email;
        }
    }

    public static boolean promptForMemberStatus(Scanner scanner) {
        while (true) {
            System.out.print("Is the member already an adherant - Yes|No- : ");
            String status = scanner.nextLine();
            if (!isNullOrBlank(status))
                return status.equalsIgnoreCase("yes");

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

}