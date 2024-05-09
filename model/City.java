package model;
import java.util.Objects;

public class City {
    private int idCity;
    private String name;
    private String region;


    public City(int idCity, String name, String region) {
        setIdCity(idCity);
        setName(name);
        setRegion(region);
    }

    public City(City source) {
        setIdCity(source.idCity);
        setName(source.name);
        setRegion(source.region);
    }

    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        if(idCity <= 0) throw new IllegalArgumentException("City ID must be greater than 0");
        this.idCity = idCity;
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
        return idCity == city.idCity && Objects.equals(name, city.name) && Objects.equals(region, city.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, name, region);
    }

    @Override
    public String toString() {
        return "[" +
            " ID='" + getIdCity() + "'" +
            "| Name='" + getName() + "'" +
            "| Region='" + getRegion() + "'" +
            "]";
    }
    
}
