import java.util.ArrayList;
import java.util.Scanner;

import pojo.Faculty;
import pojo.Field;
import repository.FieldRepository;
import repository.MemberRepository;
import service.FieldService;
import service.FieldServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

public class Main {

    // FK's should be implemented here
    static MemberRepository memberRepo = new MemberRepository();
    static MemberService mService = new MemberServiceImpl(memberRepo);

    static FieldRepository fieldRepository = new FieldRepository();
    static FieldService fService = new FieldServiceImpl(fieldRepository);
    
     
    public static void main(String[] args) {
        

        Field dba = new Field(123, "DBA", "Database Administration", "LF", 3);
        Field ce = new Field(234, "CE", "Civil Engineering", "LF", 3);
        Field fbm = new Field(566, "FBM", "Financial Banking & Marketing", "LF", 3);
        Field sen = new Field(4345, "SEN", "Software Engineering and Networking", "LP", 3);
        Field ewt = new Field(345, "EWT", "Environment Water & Techniques", "LP", 3);

        
        fService.addField(dba);
        fService.addField(ce);
        fService.addField(fbm);

        ArrayList<Field> fields = (ArrayList<Field> ) fService.getAllFields();

        Faculty fs = new Faculty(1, "FS", "Faculty of Science", fields);
        Faculty fsjes = new Faculty(2, "FSJES", "Faculty of Science and Juridical Science", fields);
        Faculty fst = new Faculty(3, "FST", "Faculty of Science and Techniques", fields);
        Faculty est = new Faculty(4, "EST", "Superior School for Technology", fields);
        Faculty ensa = new Faculty(5, "ENSA", "Superior School for Technology", fields);

       

        System.out.println();

        
        

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

    // public static void processChoice(int choice, Scanner scan, ArrayList<?> list, Manager manager) {
    //     switch (choice) {
    //         case 1:
    //             printAnyList(list, manager);
    //             break;
    //         case 2:
    //             scan.nextLine();
    //             Member newMember = createMember(scan);
    //             manager.addMember(newMember);
    //             printAnyList(manager.getMembers(), manager);
    //         case 3:
    //             scan.nextLine();
    //         default:
    //             break;
    //     }
    // }

    // public static Member createMember(Scanner scan) {
    //     String fname = promptForFirstName(scan);
    //     String lname = promptForLastName(scan);
    //     String passport = promptForPassport(scan);
    //     int matAmci = promptForMatAmci(scan);
    //     String birthDate = promptForBirthDate(scan);
    //     String email = promptForEmail(scan);
    //     boolean isMember = promptForMemberStatus(scan);

    //     Member member = new Member(0, fname, lname, birthDate, email, passport, matAmci, 2, 2, 2, 2, isMember);

    //     return member;
    // }

    // public static Field createField(Scanner scan) {
    //     String abbr = promptForFieldAbbr(scan);
    //     String name = promptForFieldName(scan);
    //     String certificate = promptForCertificate(scan);
    //     int duration = promptForDuration(scan);

    //     return new Field(1, abbr, name, certificate, duration);
    // }

    // public static Card createCard(Scanner scan) {
    //     String cin = promptForCin(scan);
    //     String reason = promptForReason(scan);
    //     String obtDate = promptForObtentionDate(scan);
    //     String expDate = promptForExpirationDate(scan);
    //     int pin = promptForPin(scan);

    //     return new Card(1, 1, 1, cin, reason, obtDate, expDate, pin);
    // }

    // public static City createCity(Scanner scan) {
    //     String name = promptForCityName(scan);
    //     String region = promptForRegion(scan);

    //     return new City(1, name, region, fillFaculties());
    // }

}