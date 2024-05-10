package model;

import java.util.ArrayList;
import java.util.Objects;

public class Faculty {
    private int id;
    private String abbr;
    private String name;

    private ArrayList<Field> fields;

    public Faculty(int id, String abbr, String name, ArrayList<Field> fields) {
        setId(id);
        setAbbr(abbr);
        setName(name);
        setFields(fields);
    }

    public Faculty(Faculty source) {
        setId(source.id);
        setAbbr(source.abbr);
        setName(source.name);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("Faculty ID must be greater than 0");
        this.id = id;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String abbr) {
        if (abbr == null || abbr.isBlank())
            throw new IllegalArgumentException("Abbreviation cannot be null or blank");
        this.abbr = abbr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Faculty name cannot be null or blank");
        this.name = name;
    }

    // Deep copy to protect the state of our object
    public ArrayList<Field> getFields() {
        ArrayList<Field> copyFields = new ArrayList<>(); 
        for (Field field : this.fields) {
            copyFields.add(new Field(field));
        }
        return copyFields;
    }

    public Field getField(int index) {
        return new Field(this.fields.get(index));
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = new ArrayList<>();
        for (Field field : fields) {
            this.fields.add(new Field(field));
        }
    }

    public void addField(Field field) {
        this.fields.add(new Field(field));
    }

    public void removeField(int index) {
        this.fields.remove(index);
    }



    @Override
    public String toString() {
        return "[" +
                " ID='" + id + "'" +
                ", Abbreviation='" + abbr + "'" +
                ", Name='" + name + "'" +
                ", Fields=" + fields.toString() +
                "]";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Faculty)) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        return id == faculty.id && Objects.equals(abbr, faculty.abbr) && Objects.equals(name, faculty.name) && Objects.equals(fields, faculty.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, abbr, name, fields);
    }


}
