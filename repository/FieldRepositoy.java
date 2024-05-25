package repository;


import java.util.HashMap;

import pojo.Field;

public class FieldRepositoy {

    private HashMap<Integer, Field> fDatastore = new HashMap<>();

    public Field createField(int id, Field field) {
        return this.fDatastore.put(id, new Field(field));
    }

    
}
