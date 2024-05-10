package model;

import java.util.ArrayList;
import java.util.Objects;

public class Faculty {
    private int id;
    private String abbr;
    private String desc;

    private ArrayList<Field> fields;

    public Faculty(int id, String abbr, String desc, ArrayList<Field> fields) {
        setId(id);
        setAbbr(abbr);
        setDesc(desc);
        setFields(fields);
    }

    public Faculty(Faculty source) {
        setId(source.id);
        setAbbr(source.abbr);
        setDesc(source.desc);
        setFields(source.fields);

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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        if (desc == null || desc.isBlank())
            throw new IllegalArgumentException("Faculty desc cannot be null or blank");
        this.desc = desc;
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
        if (index < 0 || index > this.fields.size())
            throw new IllegalArgumentException("Error: Index: " + index + " is out of bounds");
        return new Field(this.fields.get(index));
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = new ArrayList<>();
        for (Field field : fields) {
            this.fields.add(new Field(field));
        }
    }

    public void setField(int index, Field field) {
        if (index < 0 || index > this.fields.size())
            throw new IllegalArgumentException("Error: Index: " + index + " is out of bounds");
        this.fields.set(index, new Field(field));
    }

    public void addField(Field field) {
        this.fields.add(new Field(field));
    }

    public void removeField(int index) {
        if (index < 0 || index > this.fields.size())
            throw new IllegalArgumentException("Error: Index: " + index + " is out of bounds");
        this.fields.remove(index);
    }

    @Override
    public String toString() {
        return "[" +
                " ID='" + id + "'" +
                ", Abbreviation='" + abbr + "'" +
                ", Desc='" + desc + "'" +
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
        return id == faculty.id && Objects.equals(abbr, faculty.abbr) && Objects.equals(desc, faculty.desc)
                && Objects.equals(fields, faculty.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, abbr, desc, fields);
    }

}
