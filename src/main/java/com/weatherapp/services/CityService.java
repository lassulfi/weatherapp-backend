package com.weatherapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapp.domain.City;
import com.weatherapp.repositories.CityRepository;
import com.weatherapp.services.exceptions.ObjectNotFoundException;
import com.weatherapp.services.exceptions.WeathermapException;

@Service
public class CityService {

	@Autowired
	private WeathermapService weatherService;
	
	@Autowired
	private CityRepository cityRepository;
	
	/**
	 * Find all cities in the database
	 * @return
	 */
	public List<City> findAll() {
		
		return cityRepository.findAll();
	}
	
	/**
	 * Find a city by id
	 * @param id the id of an entity
	 * @return The city with the forecast updated
	 */
	
	public City findById(String id) {
		Optional<City> city = cityRepository.findById(id);
		if(city.isPresent()) {
			try {
				City obj = city.get();
				obj.setForecast(this.weatherService.getWeatherForecast(obj.getName()));
				
				return obj;
			} catch (WeathermapException e) {
				throw new ObjectNotFoundException("Objeto não encontrado");
			}
		}  else {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
	
	/**
	 * Insert a city entity in the database
	 * 
	 * @param obj city entity to be persisted
	 * @return the object that was persisted
	 */
	public City insert(City obj) {
		
		if(weatherService.isCityValid(obj.getName())) {
			return cityRepository.save(obj);
		} else {
			throw new ObjectNotFoundException("Objeto inválido. name: " + obj.getName());
		}
	}
	
	/**
	 * Delete an entity city by id
	 * @param id 
	 */
	public void delete(String id) {
		Optional<City> obj = this.cityRepository.findById(id);
		if(obj.isPresent()) {
			this.cityRepository.deleteById(id);
		} else {
			throw new ObjectNotFoundException("Objeto não encontrado. id: " + id);
		}
	}
}
