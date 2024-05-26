package service;

import java.util.List;

import pojo.Field;

public interface FieldService {
    public void addField(Field newField);
    public Field retrieveField(int id);
    public void updateField(Field newField);
    public void removeField(int id);
    public List<Field> getAllFields();
    public int autoIncrementPK();
}
