package com.bestapp.spring_and_hibernate.dao;

import com.bestapp.spring_and_hibernate.model.City;

import java.util.List;

public interface CityDAO {
    City create(City city);
    City readById(Integer id);
    List<City> readAll();
    City updateCity(City city);
    City deleteCity(City city, Integer id);
}