import java.util.Scanner;

public class Aceman {
    /*
     * Users shoudl have a menu and choose what he wants to do
     */

    static Scanner scan = new Scanner(System.in);
    static String[][] users = new String[20][13];
    static String[][] cin = new String[10][7];
    static String[][] roles = new String[3][4];
    static String[][] formations = new String[10][5];
    static String[][] fac_inst = new String[10][4];
    static String[][] villes = new String[10][3];

    public static void main(String[] args) {

        // Populate Base table
        fillHeaders();
        fillIDs();
        fillVilles();
        fillFactsInst();
        baseMembers();

        System.out.print(
                "\n\n\t\tWelcome to ACEMANAGER: an assocoiation membership application\n\n What would you like to manage ?\n\n \t1. List all members.\n\t2. Add a new member\n\t3. Remove a member.\n\t4. Update an exisiting member.\n\t4. Find a member by their name.\n\n Or\n \t5. Would you like me to generate different reports?\n\nPlease choose an option : ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                // TO DO: list members
                printTable(users);

                break;
            case 2:
                // TO DO: add a new member
                addMember();
                System.out.println("\nHere are the updated member list: ");
                printTable(users);
                break;
            case 3:
                // TO DO: delete a member

                break;
            case 4:
                // TO DO: find a member by its name

                break;
            case 5:
                // TO DO: report menu

                break;

            default:
                break;
        }

    }

    /*
     * TO DO: allow user to add members with its details
     */
    public static void addMember() {
        System.out.println("Enter thenew member details.\n");
        scan.nextLine(); // clear empty space

        System.out.print("\tFirst name: ");
        String fname = scan.nextLine();

        System.out.print("\tLast name: ");
        String lname = scan.nextLine();

        System.out.print("\tPassport : ");
        String pssprt = scan.nextLine();

        System.out.print("\tCIN : ");
        String cin = scan.nextLine();

        System.out.print("\tMatricule AMCI - type 0 if no scholarship -: ");
        String mat_amci = scan.nextLine();

        System.out.print("\tBirth Date : ");
        String birth = scan.nextLine();

        System.out.print("\tEmail : ");
        String email = scan.nextLine();

        System.out.print("\tDo you have an adhesion -type YES or NO-: ");
        String adhsion = scan.nextLine();
        while (!adhsion.equalsIgnoreCase("YES") && !adhsion.equalsIgnoreCase("NO")) {
            System.out.print("\tPlease type \"YES\" or \"NO\" ");
            adhsion = scan.nextLine().toUpperCase();
        }

        int i = 8;

        users[i + 1][1] = lname;
        users[i + 1][2] = fname;
        users[i + 1][3] = birth;
        users[i + 1][7] = pssprt;
        users[i + 1][8] = cin;
        users[i + 1][9] = mat_amci;
        users[i + 1][10] = email;
        users[i + 1][12] = adhsion;

        // id adhesion condition

        // id formation condition

        // City condition
    }

    public static void fillIDs(String[][] array) {

        for (int i = 1; i < array.length; i++) {
            array[i][0] = Integer.toString(i);
        }
    }

    public static void printTable(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            // if it's not an empty row
            if (array[i][1] != null) {
                for (int j = 0; j < array[i].length; j++) {
                    if (i == 0) {
                        System.out.print("  " + array[i][j] + "    ");
                    } else {
                        System.out.print("  " + array[i][j] + "   ");
                    }

                }
            } else {
                break;
            }

            System.out.println("\n");
        }
        System.out.println();
    }

    public static void fillIDs() {
        fillIDs(users);
        fillIDs(formations);
        fillIDs(fac_inst);
        fillIDs(villes);
        fillIDs(cin);
        fillIDs(roles);
    }

    public static void fillFactsInst() {
        fac_inst[1][0] = "1";
        fac_inst[1][1] = "FSDM";
        fac_inst[1][2] = "USMBA";
        fac_inst[1][3] = "1";

        fac_inst[2][0] = "2";
        fac_inst[2][1] = "FS MI";
        fac_inst[2][2] = "UMI";
        fac_inst[2][3] = "2";

        fac_inst[3][0] = "3";
        fac_inst[3][1] = "FS Oujda";
        fac_inst[3][2] = "UMI";
        fac_inst[3][3] = "3";

        fac_inst[3][0] = "4";
        fac_inst[3][1] = "FSK";
        fac_inst[3][2] = "UIT";
        fac_inst[3][3] = "4";
    }

    public static void fillVilles() {
        villes[1][0] = "1";
        villes[1][1] = "FES";
        villes[1][2] = "Fes-Boulemane";

        villes[2][0] = "2";
        villes[2][1] = "MEKNES";
        villes[2][2] = "Fes-Boulemane";

        villes[3][0] = "3";
        villes[3][1] = "OUJDA";
        villes[3][2] = "Fes-Boulemane";

        villes[4][0] = "4";
        villes[4][1] = "KENITRA";
        villes[4][2] = "Rabat-Sale-Kenitra";

        villes[5][0] = "5";
        villes[5][1] = "RABAT";
        villes[5][2] = "Rabat-Sale-Kenitra";

        villes[6][0] = "6";
        villes[6][1] = "SALE";
        villes[6][2] = "Rabat-Sale-Kenitra";
    }

    public static void fillHeaders() {
        // Putting headers
        users[0][0] = "ID_USR";
        users[0][1] = "LNAME";
        users[0][2] = "FNAME";
        users[0][3] = "BIRTH";
        users[0][4] = "PSSPRT";
        users[0][5] = "CIN";
        users[0][6] = "M_AMCI";
        users[0][7] = "ID_ADHSN";
        users[0][8] = "ID_CTY";
        users[0][9] = "ID_FRMTN";
        users[0][10] = "EMAIL";
        users[0][11] = "ROLE";
        users[0][12] = "ADHRNT_STS";

        cin[0][0] = "ID_CIN";
        cin[0][1] = "ID_USR";
        cin[0][2] = "ID_CTY";
        cin[0][3] = "OBTN_YR";
        cin[0][4] = "EXPR8YR";
        cin[0][5] = "ADRSS";
        cin[0][6] = "PIN";

        roles[0][0] = "ID_ROLE";
        roles[0][1] = "NM_roles";
        roles[0][2] = "SSN_STRT";
        roles[0][3] = "SSN_END";

        formations[0][0] = "ID_FRMT";
        formations[0][1] = "ID_FC_INST";
        formations[0][2] = "NM_FRMT";
        formations[0][3] = "DRTN_FRMT";
        formations[0][4] = "YR_RPT";

        fac_inst[0][0] = "ID_FCT_INST";
        fac_inst[0][1] = "UNIVERSITY";
        fac_inst[0][2] = "NM_FAC_INST";
        fac_inst[0][3] = "ID_CTY";

        villes[0][0] = "ID_CTY";
        villes[0][1] = "NM_CTY";
        villes[0][2] = "NM_RGN";
    }

    public static void baseMembers() {
        
        users[1][0] = "1";
        users[1][1] = "TOIHIR";
        users[1][2] = "AL FAHAMI";
        users[1][3] = "21/05/1992";
        users[1][4] = "NBE3457564";
        users[1][5] = "C016745J"; 
        users[1][6] = "20111489";
        users[1][7] = "14"; // id_adhesion
        users[1][8] = "1"; // id_ville
        users[1][9] =  "3"; // id_frmtion
        users[1][10] = "altoihir@gmail.com";
        users[1][11] = "1";
        users[1][12] = "YES";

        users[2][0] = "2";
        users[2][1] = "HAFIDHOU";
        users[2][2] = "HAFIDHOU";
        users[2][3] = "22/05/2998";
        users[2][4] = "NBE345678";
        users[2][5] = "C016745B";
        users[2][6] = "202478";
        users[2][7] = "22";// id_adhesion
        users[2][8] = "1"; // id_ville;
        users[2][9] = "4"; // id_frmtion
        users[2][10] = "haf@gmail.com";
        users[2][11] = "3"; // id_role
        users[2][12] = "YES"; // status_adhesion

        users[3][0] = "3";
        users[3][1] = "CHARFIA";
        users[3][2] = "MOHAMED";
        users[3][3] = "22/09/2001";
        users[3][4] = "NBE345678";
        users[3][5] = "C016745B";
        users[3][6] = "202478";
        users[3][7] = "22";// id_adhesion;
        users[3][8] = "4"; // id_city
        users[3][9] = "4"; // id_frmtion
        users[3][10] = "charf@gmail.com";
        users[3][11] = "3"; // id_role
        users[3][12] = "YES"; // status_adhesion

        users[4][0] = "4";
        users[4][1] = "DAKOINE";
        users[4][2] = "TOIHIR";
        users[4][3] = "12/08/1999";
        users[4][4] = "NBE345678";
        users[4][5] = "C016745B";
        users[4][6] = "404478";
        users[4][7] = "44";// id_adhesion
        users[4][8] = "1"; //id_city
        users[4][9] = "4"; // id_frmtion
        users[4][10] = "onedak@gmail.com";
        users[4][11] = "3"; // id_role
        users[4][12] = "YES"; // status_adhesion

        users[5][0] = "5";
        users[5][1] = "ANDJOUZA";
        users[5][2] = "ADAM";
        users[5][3] = "22/05/2002";
        users[5][4] = "NBE545678";
        users[5][5] = "C016745B";
        users[5][6] = "202478";
        users[5][7] = "22";// id_adhesion;
        users[5][8] = "1"; // id_ville;
        users[5][9] = "4"; // id_frmtion
        users[5][10] = "andjz@gmail.com";
        users[5][11] = "3"; // id_role
        users[5][12] = "YES"; // status_adhesion

        users[6][0] = "6";
        users[6][1] = "DJAWAD";
        users[6][2] = "SIDI";
        users[6][3] = "22/06/2005";
        users[6][4] = "NBE646678"; 
        users[6][5] = "C016746B";
        users[6][6] = "202478";
        users[6][7] = "26";// id_adhesion
        users[6][8] = "1"; // id_ville
        users[6][9] = "5"; // id_frmtion;
        users[6][10] = "djaoid@gmail.com";
        users[6][11] = "3"; // id_role
        users[6][12] = "YES"; // status_adhesion

        users[7][0] = "7";
        users[7][1] = "BEHRAM";
        users[7][2] = "MAHAMET";
        users[7][3] = "22/07/1998";
        users[7][4] = "NBE74778";
        users[7][5] = "C017747B";
        users[7][6] = "202478";
        users[7][7] = "65";// id_adhesion;
        users[7][8] = "1"; // id_ville;
        users[7][9] = "1"; // id_frmtion
        users[7][10] = "benms@gmail.com";
        users[7][11] = "3"; // id_role
        users[7][12] = "YES"; // status_adhesion

        users[8][0] = "8";
        users[8][1] = "ISSIHAKA";
        users[8][2] = "MOHAMED";
        users[8][3] = "22/08/1990";
        users[8][4] = "NBE8488";
        users[8][5] = "C018848B";
        users[8][6] = "202488";
        users[8][7] = "65";// id_adhesion
        users[8][8] = "1"; // id_ville
        users[8][9] = "1"; // id_frmtion
        users[8][10] = "ismoh@gmail.com";
        users[8][11] = "3"; // id_role
        users[8][12] = "YES"; // status_adhesion
    }

}
