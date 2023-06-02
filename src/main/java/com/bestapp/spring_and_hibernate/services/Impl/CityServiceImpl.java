package com.bestapp.spring_and_hibernate.services.Impl;

import com.bestapp.spring_and_hibernate.dao.CityDAO;
import com.bestapp.spring_and_hibernate.model.City;
import com.bestapp.spring_and_hibernate.services.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {

    private final CityDAO cityDAO;

    public CityServiceImpl(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public City create(City city) {
        cityDAO.create(city);
        return city;
    }

    @Override
    public City readById(int id) {
        return cityDAO.readById(id);
    }

    @Override
    public List<City> readAll() {
        return cityDAO.readAll();
    }

    @Override
    public City updateCity(City city) {
        cityDAO.updateCity(city);
        return city;
    }

    @Override
    public City deleteCity(City city, int id) {
        cityDAO.deleteCity(city, id);
        return city;
    }
}
