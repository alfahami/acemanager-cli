package model.manager;

import java.util.ArrayList;

import model.City;
import java.util.Objects;

// Can add Fac through city
public class Admin extends Moderator {

    // TODO: change return on set, remove functionalities as they return the modified elements
    private ArrayList<City> cities;

    public Admin() {
        super();
        this.cities = new ArrayList<>();
    }

    public Admin(Admin source) {
        super();
        this.addCards(source.getCards());
    }

    public ArrayList<City> getCities() {
        if(this.cities.isEmpty()) throw new IllegalArgumentException("No city found in cities table, add some");
        ArrayList<City> copyCities = new ArrayList<>();
        for (City city : this.cities) {
            copyCities.add(new City(city));
        }
        return copyCities;
    }

    public City getCity(int index) {
        if (index < 0 || index > this.cities.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return new City(this.cities.get(index));
    }

    public void addCity(City city) {
        if(city == null) throw new IllegalArgumentException("City cannot be null");
        this.cities.add(new City(city));
    }

    public void addCities(ArrayList<City> cities) {
        if(cities.isEmpty()) throw new IllegalArgumentException("New city list cannot be empty");
        for (City city : cities) {
            this.cities.add(new City(city));
        }
    }

    public void updateCity(int index, City newCity) {
        if (index < 0 || index > this.cities.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        this.cities.set(index, new City(newCity));
    }

    public void removeCity(int index) {
        if (index < 0 || index > this.cities.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        this.cities.remove(index);
    }

    @Override
    public String toString() {
        return "{" +
            " Cities='" + cities.toString() + "'" +
            ", Members='" + getMembers().toString() + "'" + 
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Admin)) {
            return false;
        }
        Admin admin = (Admin) o;
        return Objects.equals(cities, admin.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cities);
    }   


}
