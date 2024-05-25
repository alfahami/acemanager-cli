package repository;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import pojo.Field;

public class FieldRepositoy {

    private HashMap<Integer, Field> datastore = new HashMap<>();

    public Field createField(int id, Field field) {
        return this.datastore.put(id, new Field(field));
    }

    public Field retrievField(int id) {
        return new Field(this.datastore.get(id));
    }

    public Field updateField(Field field) {
        return this.datastore.put(field.getId(), new Field(field));
    }

    public void removeField(int id) {
        this.datastore.remove(id);
    }

    public List<Field> getFieldList() {
        return this.datastore.values().stream()
                            .sorted((f1, f2) -> Integer.compare(f1.getId(), f2.getId()))
                            .collect(Collectors.toList());
    }

    
}
