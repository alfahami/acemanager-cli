package service;

import java.util.List;

import pojo.City;

public interface CityService {

    public void addCity(City newCity);
    public void updateCity(City newCity);
    public City retrieveCity(int id);
    public List<City> getCityList();
    public int autoIncrementPK();

    
}
