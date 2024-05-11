package model.manager;

import java.util.ArrayList;

import model.City;
import java.util.Objects;

public class Admin extends Moderator {

    // TODO: change return on set, remove functionalities as they return the modified elements
    private ArrayList<City> cities;
    private ArrayList<Moderator> mods;

    public Admin() {
        super();
        this.cities = new ArrayList<>();
        this.mods = new ArrayList<>();
    }

    public Admin(Admin source) {
        super();
        this.addMods(source.getMods());
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

    public ArrayList<Moderator> getMods() {
        if(this.mods.isEmpty()) throw new IllegalArgumentException("You don't have moderator yet, add some");
        ArrayList<Moderator> copyMods = new ArrayList<>();
        for (Moderator moderator : this.mods) {
            copyMods.add(new Moderator(moderator));
        }
        return copyMods;
    }

    public Moderator getModerator(int index) {
        if (index < 0 || index > this.mods.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        return new Moderator(this.mods.get(index));
    }

    public void addModerator(Moderator moderator) {
        if(moderator == null) throw new IllegalArgumentException("Moderator cannot be null");
        this.mods.add(new Moderator(moderator));
    }

    public void addMods(ArrayList<Moderator> mods) {
        if(mods.isEmpty()) throw new IllegalArgumentException("New moderator list cannot be empty, add some mods before");
        for (Moderator moderator : mods) {
            this.mods.add(new Moderator(moderator));
        }
    }

    public void updateModerator(int index, Moderator newModerator) {
        if (index < 0 || index > this.mods.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        this.mods.set(index, new Moderator(newModerator));
    }

    public void removeModerator(int index) {
        if (index < 0 || index > this.mods.size())
            throw new IllegalArgumentException("Error: index " + index + "out of bounds");
        this.mods.remove(index);
    }


    @Override
    public String toString() {
        return "{" +
            " cities='" + cities.toString() + "'" +
            ", mods='" + mods.toString() + "'" +
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
        return Objects.equals(cities, admin.cities) && Objects.equals(mods, admin.mods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cities, mods);
    }   


}
