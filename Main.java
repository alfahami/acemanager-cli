import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pojo.Member;
import repository.MemberRepository;
import service.MemberService;
import service.MemberServiceImpl;

public class Main {

    // FK's should be implemented here
    static MemberRepository mRepo = new MemberRepository();
    static MemberService mService = new MemberServiceImpl(mRepo);

    public static void main(String[] args) {

    
        Member mbr0 = new Member(0, "TUPAC", "SHAKUR", "23/09/1992", "tup@gmail.com", "NBE456098", 20212332, 2, 2, 2, 2, true);

        Member mbr1 = new Member(0, "AMED", "ALI SAID", "12/09/1989", "amed@gmail.com", "nbe388409", 20212345, 1,  1, 1, 1, true);

        Member mbr2 = new Member(0, "HISSANE", "IRCHAD", "23/10/1990", "his@gmail.com", "nbe319590", 20212346, 2, 2, 2, 2, true);

        Member mbr3 = new Member(0, "CHARKAOUI", "ISSA", "03/03/1993", "issa@gmail.com", "nbe509879", 20212347, 3, 3, 3, 3, true);

        Member mbr4 = new Member(0, "MSA", "YOUSSOUF", "09/11/1990", "msa@gmail.com", "nbe388985", 20212345, 4, 4, 4, 4, true);

        Member mbr5 = new Member(0, "ILYASS", "HAIDAR", "08/01/2000", "ilys@gmail.com", "nbe388789", 20212345, 5, 5, 5, 5, true);
        
        mService.addMember(mbr0);
        mService.addMember(mbr1);
        mService.addMember(mbr2);
        mService.addMember(mbr3);
        mService.addMember(mbr4);
        mService.addMember(mbr5);

        Member retrieveMember = mService.retrievMember(mbr3.getPassport());
        System.out.println(retrieveMember.toString());

        mService.deleteMember(mbr5.getPassport());
        List<Member> members = mService.getMembersArrays();

        System.out.println(members.toString());
    

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