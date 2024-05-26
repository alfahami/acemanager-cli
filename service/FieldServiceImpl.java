package service;

import java.util.List;

import pojo.Field;
import repository.FieldRepository;

public class FieldServiceImpl implements FieldService {

    private FieldRepository repository;


    public FieldServiceImpl(FieldRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addField(Field newField) {
        newField.setId(autoIncrementPK());
        this.repository.createField(newField.getId(), newField);
    }

    @Override
    public Field retrieveField(int id) {
        return new Field(this.repository.retrieveField(id));
    }

    @Override
    public void updateField(Field newField) {
        this.repository.updateField(newField);
    }

    @Override
    public void removeField(int id) {
        this.repository.removeField(id);
    }

    @Override
    public List<Field> getAllFields() {
        return this.repository.getFieldList();
    }

    @Override
    public int autoIncrementPK() {
        if(this.repository.getFieldList() != null && this.repository.getFieldList().size() >= 1) return this.repository.getFieldList().size() + 1;
        else return 1;
    }

}
