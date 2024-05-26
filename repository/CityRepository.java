package repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import pojo.City;

public class CityRepository {
    
        private HashMap<Integer, City> datasource = new HashMap<>();

        public City createCity(int id, City city) {
            return this.datasource.put(id, new City(city));
        }

        public City retrieveCity(int id) {
            if(this.datasource == null || id > this.datasource.size() || id < this.datasource.size()) throw new IllegalArgumentException("No city found");
            return new City(this.datasource.get(id));
        }

        public City updateCity(int id, City newCity) {
            return this.datasource.put(id, new City(newCity));
        }

        public City deleteMember(int id) {
            return this.datasource.remove(id);
        }

        public List<City> getCityList() {
            return this.datasource.values().stream()
                        .sorted((city1, city2) -> Integer.compare(city1.getId(), city2.getId())).collect(Collectors.toList());
        }
}