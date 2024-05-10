import java.util.ArrayList;

import model.City;
import model.Faculty;
import model.Field;
import model.Member;
import model.manager.Acemanager;
import model.manager.Moderator;

public class Main {

    public static void main(String[] args) {
        Member std1 = new Member(1, "TUPAC", "Shakur", "21/12/1992", "tupac@gmail.com", "NBE388589", 20111473, 1, 1, 1, 1, 1, true);

        Member std2 = new Member(1, "TEST", "Mbokani", "21/12/1996", "test@gmail.com", "NBE388409", 20111470, 1, 1, 1, 1, 1, true);

        Member std3 = new Member(1, "Boka", "Nahazou", "13/08/1998", "boka@gmail.com", "NBE388898", 20111472, 1, 1, 1, 1, 1, true);

        Member std4 = new Member(1, "Ajmal", "Fouad", "20/01/2000", "ajmal@gmail.com", "NBE388991", 20111476, 1, 1, 1, 1, 1, true);

        ArrayList<Member> members = new ArrayList<>();

        members.add(std1);
        members.add(std2);
        members.add(std3);
        members.add(std4);

        Moderator modFes = new Moderator();
        modFes.setSession_start();
        System.out.println("Session start: " +modFes.getSession_start());

        modFes.addMember(std1);
        modFes.addMember(std2);
        modFes.addMember(std3);
        modFes.addMember(std4);

        
        System.out.println("\n\nLet's find member who has NBE388507 as passport" + modFes.findMember("NBE311111").toString());
        
        System.out.println("\nBefore rm mbr2: \n\n" + modFes.toString());
        modFes.removeMemeber(1);
        System.out.println("\n\nAfter removal: \n\n" + modFes.toString());
        System.out.println("\n\nRetrieved member to update" + modFes.getMember(2).toString());
        
        modFes.updateMemeber(2, new Member(1, "Hercule", "Mmona", "09/02/1999", "hercule@gmail.com", "NBE456890", 20201943, 1, 1, 1, 1, 1, true));
        
        System.out.println("\n\nRetrieved member after update" + modFes.getMember(2).toString());

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