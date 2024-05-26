package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public void removeFaculty(String key) {
       this.datasource.remove(key);
    }

    public List<Faculty> getFaucltyList() {
        return this.datasource.values().stream()
                        .sorted((fac1, fac2) -> Integer.compare(fac1.getId(), fac2.getId()))
                        .collect(Collectors.toList());
    }
}
