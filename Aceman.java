import java.util.Scanner;

public class Aceman {
    /*
     * Users shoudl have a menu and choose what he wants to do
     */

     static Scanner scan = new Scanner(System.in);
     static String[][] users = new String[5][13];
     static String[][] cin   = new String[5][7];
     static String[][] roles  = new String[5][4];
     static String[][] formations = new String[5][5];
     static String[][] fac_inst = new String[4][4];
     static String[][] villes = new String[7][3];
    public static void main(String[] args) {
        
        // Populate Base table
        fillHeaders();
        fillIDs();
        fillVilles();
        fillFactsInst();

        // print test
        printTable(villes);
        System.out.println();
        System.out.println();
        printTable(fac_inst);

        System.out.print("\n\n\t\tWelcome to ACEMANAGER: a assocoiatin membership application\n\n What would you like to manage ?\n\n \t1. List all members.\n\t2. Add a new member\n\t3. Remove a member.\n\t4. Update an exisiting member.\n\t4. Find a member by their name.\n\n Or\n \t5. Would you like me to generate different reports?\n\nPlease choose an option : ");
        int choice = scan.nextInt();
        
        switch (choice) {
            case 1:
                // TO DO: list members 
                printTable(users);
                break;
            case 2:
                // TO DO: add a new member

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


    public static void fillIDs(String[][] array) {
        
            for (int i = 1; i < array.length; i++) {
                array[i][0] = Integer.toString(i);
            } 
    }

    public static void printTable(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i == 0){
                    System.out.print("  " + array[i][j] + " ");
                } else {
                    System.out.print("  " + array[i][j] + "    ");
                }
            }
            System.out.println("\n");
        }
        System.out.println();
    } 

    public static void fillIDs(){
        fillIDs(users);
        fillIDs(formations);
        fillIDs(fac_inst);
        fillIDs(villes);
        fillIDs(cin);
        fillIDs(roles);
    }

    public static void fillFactsInst(){
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

    public static void fillVilles(){
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

    public static void fillHeaders(){
        // Putting headers
        users[0][0] = "ID_USR";
        users[0][1] = "PSSPRT";
        users[0][2] = "CIN";
        users[0][3] = "M_AMCI";
        users[0][4] = "ID_CTY";
        users[0][5] = "ID_ADHSN";
        users[0][6] = "ID_FRMTN";
        users[0][7] = "LNAME";
        users[0][8] = "FNAME";
        users[0][9] = "BIRTH";
        users[0][10] = "EMAIL";
        users[0][11] = "ROLE";
        users[0][12] = "ADHRNT";

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

    
}
