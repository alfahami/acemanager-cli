package model;

import java.util.Objects;

public class Faculty {
    private int id;
    private String abbr;
    private String name;
    

    public Faculty(int id, String abbr, String name) {
        setId(id);
        setAbbr(abbr);
        setName(name);
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
        if(abbr == null || abbr.isBlank()) throw new IllegalArgumentException("Abbreviation cannot be null or blank");
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

    @Override
    public String toString() {
        return "[" +
                " ID='" + id + "'" +
                ", Name='" + name + "'" +
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
        return id == faculty.id && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
