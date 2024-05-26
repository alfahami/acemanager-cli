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
}
