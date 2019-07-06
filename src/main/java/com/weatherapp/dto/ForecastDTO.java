package com.weatherapp.dto;

import java.io.Serializable;
import java.util.List;

import com.weatherapp.domain.City;
import com.weatherapp.domain.Forecast;

public class ForecastDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String cityName;
	private List<Forecast> forecast;
	
	public ForecastDTO() {
		
	}
	
	public ForecastDTO(City obj) {
		this.id = obj.getId();
		this.cityName = obj.getName();
		this.forecast = obj.getForecast();
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

	public List<Forecast> getForecast() {
		return forecast;
	}

	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}
}
