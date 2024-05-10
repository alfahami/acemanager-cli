import java.util.ArrayList;

import model.City;
import model.Faculty;
import model.Field;

public class Main {

    public static void main(String[] args) {
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

        System.out.println(fs.toString()+"\n\n\n");

        fs.removeField(0);

        System.out.println("Removed the first field\n\n" + fs.toString());
        
        System.out.println("Before update: " + fs.getField(3).toString());
        fs.setField(3, new Field(6, 1, "INGE", "Ingénieur", 3));

        System.out.println("\n\nUpdated Field: " + fs.getField(3).toString());




/*
        ArrayList<Faculty> facs = new ArrayList<>();
        facs.add(fs);
        facs.add(fst);
        facs.add(fsjes);
        facs.add(est);
        facs.add(ensa);

        System.out.println(facs.toString()+"\n\n\n");

        City fes = new City(1, "FES", "FES-BOULEMANE", facs);
        Faculty fm = new Faculty(6, "FM", "Faculty of Medecine", fields);
        fes.addFaculty(fm);

        Faculty retrievedFaculty = fes.getFaculty(0);
        System.out.println(retrievedFaculty.toString()+"\n\n");
        fes.deleteFaculty(0);

        System.out.println("\n\n\n");
        System.out.println(fes.getFacs().toString());        
    */
    }
}