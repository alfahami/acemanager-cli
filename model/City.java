package model;

import java.util.ArrayList;
import java.util.Objects;

public class City {
    private int id;
    private String name;
    private String region;

    private ArrayList<Faculty> facs;

    public City(int id, String name, String region, ArrayList<Faculty> facs) {
        setId(id);
        setName(name);
        setRegion(region);
        setFacs(facs);
    }

    public City(City source) {
        setId(source.id);
        setName(source.name);
        setRegion(source.region);
        setFacs(source.facs);
    }

    public int getid() {
        return this.id;
    }

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("City ID must be greater than 0");
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("City name cannot be null or blank");
        this.name = name;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        if (region == null || region.isBlank())
            throw new IllegalArgumentException("Region name cannot be null or blank");
        this.region = region;
    }

    public int getId() {
        return this.id;
    }

    // Deep copying in order to protect the sate of our object
    public Faculty getFaculty(int index) {
        if (index < 0 || index > this.facs.size())
            throw new IllegalArgumentException("Error: Index: " + index + " is out of bounds");
        return new Faculty(this.facs.get(index));
    }

    public ArrayList<Faculty> getFacs() {
        ArrayList<Faculty> copyFacs = new ArrayList<>();
        for (Faculty faculty : this.facs) {
            copyFacs.add(new Faculty(faculty));
        }
        return copyFacs;
    }

    public void setFacs(ArrayList<Faculty> facs) {
        this.facs = new ArrayList<>();
        for (Faculty faculty : facs) {
            this.facs.add(new Faculty(faculty));
        }
    }

    public Faculty setFaculty(int index, Faculty newFaculty) {
        if (index < 0 || index > this.facs.size())
            throw new IllegalArgumentException("Error: Index: " + index + " is out of bounds");
        return this.facs.set(index, new Faculty(newFaculty));
    }

    public boolean addFaculty(Faculty newFaculty) {
        if(newFaculty == null) throw new IllegalArgumentException("New Faculty cannot be null");
        return this.facs.add(new Faculty(newFaculty));
    }

    public Faculty removeFaculty(int index) {
        if (index < 0 || index > this.facs.size())
            throw new IllegalArgumentException("Error: Index: " + index + " is out of bounds");
        return this.facs.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof City)) {
            return false;
        }
        City city = (City) o;
        return id == city.id && Objects.equals(name, city.name) && Objects.equals(region, city.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, region);
    }

    @Override
    public String toString() {
        return "{" +
                " ID='" + id + "'" +
                ", Name='" + name + "'" +
                ", Region='" + region + "'" +
                "}";
    }

}
