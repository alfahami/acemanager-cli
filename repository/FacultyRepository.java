package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pojo.Faculty;
import pojo.Field;

public class FacultyRepository {
    private HashMap<String, Faculty> datasource = new HashMap<>();
    
    public Faculty createFaculty(String abbr, Faculty newFaculty) {
        return this.datasource.put(abbr, new Faculty(newFaculty));
    }

    public Faculty retrieFaculty(String key) {
        return new Faculty(this.datasource.get(key));
    }

    public Faculty updateFaculty(Faculty newFaculty) {
        return this.datasource.put(newFaculty.getAbbr(), new Faculty(newFaculty));
    }
}
