package model;
import java.util.Objects;

public class City {
    private int id;
    private String name;
    private String region;


    public City(int id, String name, String region) {
        setId(id);
        setName(name);
        setRegion(region);
    }

    public City(City source) {
        setId(source.id);
        setName(source.name);
        setRegion(source.region);
    }

    public int getid() {
        return this.id;
    }

    public void setId(int id) {
        if(id <= 0) throw new IllegalArgumentException("City ID must be greater than 0");
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("City name cannot be null or blank");
        this.name = name;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        if(region == null || region.isBlank()) throw new IllegalArgumentException("Region name cannot be null or blank");
        this.region = region;
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
        return "\n[" +
            " ID='" + id + "'" +
            ", Name='" + name + "'" +
            ", Region='" + region + "'" +
            "]";
    }
    
}
