package repository;

import java.util.HashMap;

import pojo.City;

public class CityRepository {
    
        private HashMap<Integer, City> cDatastore = new HashMap<>();

        public City createCity(int id, City city) {
            return this.cDatastore.put(id, new City(city));
        }

        public City retrieveCity(int id) {
            if(this.cDatastore == null || id > this.cDatastore.size() || id < this.cDatastore.size()) throw new IllegalArgumentException("No city found");
            return new City(this.cDatastore.get(id));
        }

        public City updateMember(int id, City newCity) {
            return this.cDatastore.put(id, new City(newCity));
        }

        public City deleteMember(int id) {
            return this.cDatastore.remove(id);
        }
}