package lib;

import model.City;
import model.Faculty;
import model.Field;

public class FillTables {

    private final static void fillFields() {
        Field smi = new Field(1, 2, "SMI", "Mathematic and Computer Science", "LF", 3);
        Field sma = new Field(1, 2, "SMI", "Mathematic and Computer Science", "LF", 3);
    }

    private final static void fillFaculty() {
        Faculty fs = new Faculty(1, "FS", "Faculty of Science", null);
    }
    private final static void fillCities() {
        City fes = new City(1, "FES", "FES-BOULEMANE", null);
    }
    
    public final static void fillMembers() {

    }    
}
