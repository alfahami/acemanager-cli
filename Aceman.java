public class Aceman {
    /*
     * Users shoudl have a menu and choose what he wants to do
     */
    public static void main(String[] args) {

        // Base arrays
        String[][] users = new String[5][13];
        String[][] cin   = new String[5][7];
        String[][] roles  = new String[5][4];
        String[][] formations = new String[5][5];
        String[][] fac_inst = new String[5][3];
        String[][] villes = new String[3][3];

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
        fac_inst[0][1] = "NM_FAC_INST";
        fac_inst[0][2] = "ID_CTY";

        villes[0][0] = "ID_CTY";
        villes[0][1] = "NM_CTY";
        villes[0][2] = "NM_RGN";

        // Populate IDs
        fillIDs(users);
        fillIDs(formations);
        fillIDs(fac_inst);
        fillIDs(villes);
        fillIDs(cin);
        fillIDs(roles);
        // printing tables
        printTable(users);
        
        
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
                    System.out.print("  " + array[i][j] + "  ");
                } else {
                    System.out.print("  " + array[i][j] + "    ");
                }
            }
            System.out.println("\n");
        }
        System.out.println();
    } 
}
