package com.weatherapp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.weatherapp.domain.City;
import com.weatherapp.domain.Weather;

public class ForecastDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String cityName;
	private List<Weather> forecast = new ArrayList<>();
	
	public ForecastDTO() {
		
	}
	
	public ForecastDTO(City obj) {
		this.id = obj.getId();
		this.cityName = obj.getName();
		obj.getForecast().forEach(el -> this.forecast.add(el.getWeather().get(0)));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Weather> getForecast() {
		return forecast;
	}

	public void setForecast(List<Weather> forecast) {
		this.forecast = forecast;
	}
}
