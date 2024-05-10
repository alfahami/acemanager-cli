import java.util.ArrayList;

import model.Card;
import model.Member;
import model.manager.Moderator;

public class Main {

    public static void main(String[] args) {

        Card card1 = new Card(1, 1, 1, "C018507J", "WORK", "01/12/2024", "01/12/2027", 1234);
        Card card2 = new Card(2, 2, 1, "C018597J", "STUDY", "09/10/2024", "09/10/2027", 1098);
        Card card3 = new Card(3, 3, 1, "C028556J", "STUDY", "21/09/2023", "21/09/2026", 1076);
        Card card4 = new Card(1, 1, 1, "C028450M", "WORK", "09/11/2023", "09/11/2026", 9876);
       
        
        Member std1 = new Member(1, "TUPAC", "Shakur", "21/12/1992", "tupac@gmail.com", "NBE388589", 20111473, 1, 1, 1, 1, 1, true);

        Member std2 = new Member(1, "TEST", "Mbokani", "21/12/1996", "test@gmail.com", "NBE388409", 20111470, 1, 1, 1, 1, 1, true);

        Member std3 = new Member(1, "Boka", "Nahazou", "13/08/1998", "boka@gmail.com", "NBE388898", 20111472, 1, 1, 1, 1, 1, true);

        Member std4 = new Member(1, "Ajmal", "Fouad", "20/01/2000", "ajmal@gmail.com", "NBE388991", 20111476, 1, 1, 1, 1, 1, true);

        Moderator modFes = new Moderator();
        modFes.setSession_start();
        System.out.println("Session start: " + modFes.getSession_start());

         modFes.addMember(std1);
         modFes.addMember(std2);
         modFes.addMember(std3);
         modFes.addMember(std4);
         modFes.addCard(card1);
         modFes.addCard(card2);
         modFes.addCard(card3);
         modFes.addCard(card4);

        
        //System.out.println("\n\nLet's find member who has NBE388507 as passport" + modFes.findMember("NBE311111").toString());
        
        System.out.println("\nBefore rm mbr2: \n\n" + modFes.toString());
        modFes.removeCard(1);
        System.out.println("\n\nAfter removal: \n\n" + modFes.toString());
        System.out.println("\n\nRetrieved member to update" + modFes.getCard(2).toString());
        
        modFes.updateCard(2, new Card(6, 8, 1, "C000098H", "CLANDO", "09/11/2023", "09/11/2026", 9654));
        
        System.out.println("\n\nRetrieved member after update" + modFes.getCard(2).toString());

        System.out.println();

        modFes.setSession_end();
        System.out.println("Session end: " +modFes.getSession_end());

        //System.out.println(modFes);

        /*
        Field smi = new Field(1, 1, "SMI", "LF", 3);
        Field smc = new Field(2, 1, "SMC", "LF", 3);
        Field smp = new Field(3, 1, "SMP", "LF", 3);
        Field sma = new Field(4, 1, "SMA", "LF", 3);

        ArrayList<Field> fields = new ArrayList<>();
        fields.add(smi);
        fields.add(smc);
        fields.add(smp);
        fields.add(sma);

        System.out.println("\n\nFaculty Fields management\n\n");

        Faculty fs = new Faculty(1, "FS", "Faculty of Science Dar Mehraz", fields);
        Faculty fst = new Faculty(2, "FST", "Faculty of Science and techniques", fields);
        Faculty fsjes = new Faculty(3, "FSJES", "Faculty of Science and Juridic", fields);
        Faculty est = new Faculty(4, "EST", "Superior School of Technology", fields);
        Faculty ensa = new Faculty(5, "ENSA", "National School of Applied Science", fields);

        fst = new Faculty(fs);

        System.out.println("Equality Test : " + fst.equals(fs));

        fs.addField(new Field(5, 1, "MIP", "LF", 4));
        fs.addField(new Field(6, 1, "DBA", "LF", 3));

        System.out.println(fs.toString() + "\n\n\n");

        fs.removeField(0);

        System.out.println("Removed the first field\n\n" + fs.toString());

        System.out.println("Before update: " + fs.getField(3).toString());
        fs.setField(3, new Field(6, 1, "INGE", "Ingénieur", 3));

        System.out.println("\n\nUpdated Field: " + fs.getField(3).toString());

        ArrayList<Faculty> facs = new ArrayList<>();
        facs.add(fs);
        facs.add(fst);
        facs.add(fsjes);
        facs.add(est);
        facs.add(ensa);

        System.out.println(facs.toString() + "\n\n\n");

        City fes = new City(1, "FES", "FES-BOULEMANE", facs);
        Faculty fm = new Faculty(6, "FM", "Faculty of Medecine", fields);
        fes.addFaculty(fm);

        Faculty retrievedFaculty = fes.getFaculty(0);
        System.out.println(retrievedFaculty.toString() + "\n\n");
        fes.removeFaculty(90);

        System.out.println("\n\n\n");
        System.out.println(fes.getFacs().toString());
        */

    }
}