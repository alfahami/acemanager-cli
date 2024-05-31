package service;

import java.util.List;

import pojo.City;
import pojo.Member;
import repository.CityRepository;

public class CityServiceImpl implements CityService {

    private CityRepository repository;


    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addCity(City newCity) {
        newCity.setId(autoIncrementPK());
        this.repository.createCity(newCity.getId(), newCity);
    }

    @Override
    public void updateCity(City newCity) {
        this.repository.updateCity(newCity.getId(), newCity);
    }

    @Override
    public City retrieveCity(int id) {
        return this.repository.retrieveCity(id);
    }

    @Override
    public List<City> getCityList() {
        return this.repository.getCityList();
    }

    @Override
    public int autoIncrementPK() {
        if(this.repository.getCityList() != null && this.repository.getCityList().size() > 0) return this.repository.getCityList().size() + 1;
        else return 1;
    }
    
}
