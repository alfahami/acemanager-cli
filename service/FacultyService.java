package service;

import java.util.List;

import pojo.Faculty;

public interface FacultyService {
    public void addFaculty(Faculty newFaculty);
    public Faculty retrieFaculty(String key);
    public void updateFaculty(Faculty newFaculty);
    public void deleteFaculty(String key);
    public List<Faculty> getFacultyList();
    public int autoIncrementPK();
    
} 
