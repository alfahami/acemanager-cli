import java.util.ArrayList;

import model.City;
import model.Faculty;

public class Main {

    public static void main(String[] args) {
        Faculty fs = new Faculty(1, "FS", "Faculty of Science Dar Mehraz");
        Faculty fst = new Faculty(2, "FST", "Faculty of Science and techniques");
        Faculty fsjes = new Faculty(3, "FSJES", "Faculty of Science and Juridic");
        Faculty est = new Faculty(4, "EST", "Superior School of Technology");
        Faculty ensa = new Faculty(5, "ENSA", "National School of Applied Science");

        ArrayList<Faculty> facs = new ArrayList<>();
        facs.add(fs);
        facs.add(fst);
        facs.add(fsjes);
        facs.add(est);
        facs.add(ensa);

        System.out.println(facs.toString()+"\n\n\n");

        City fes = new City(1, "FES", "FES-BOULEMANE", facs);
        Faculty fm = new Faculty(6, "FM", "Faculty of Medecine");
        fes.addFaculty(fm);

        Faculty retrievedFaculty = fes.getFaculty(0);
        System.out.println(retrievedFaculty.toString()+"\n\n");
        fes.deleteFaculty(0);

        System.out.println("\n\n\n");

        System.out.println(fes.getFacs().toString());        
    }
}