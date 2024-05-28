package service;

import java.util.List;

import pojo.Faculty;
import repository.FacultyRepository;

public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository repository;


    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addFaculty(Faculty newFaculty) {
        newFaculty.setId(autoIncrementPK());
        this.repository.createFaculty(newFaculty.getAbbr(), newFaculty);
    }

    @Override
    public Faculty retrieveFaculty(String key) {
        return this.repository.retrieFaculty(key);
    }

    @Override
    public void updateFaculty(Faculty newFaculty) {
        this.repository.updateFaculty(newFaculty);
    }

    @Override
    public void deleteFaculty(String key) {
        this.repository.removeFaculty(key);
    }

    @Override
    public List<Faculty> getFacultyList() {
        return this.repository.getFaucltyList();
    }

    @Override
    public int autoIncrementPK() {
        if(this.repository.getFaucltyList() != null && this.repository.getFaucltyList().size() > 0) return this.repository.getFaucltyList().size() + 1;
        else return 1;
    }
    
}
