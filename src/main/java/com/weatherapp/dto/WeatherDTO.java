package com.weatherapp.dto;

import java.io.Serializable;

import com.weatherapp.domain.Weather;

public class WeatherDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String main;
	private String description;
	private String icon;
	private String date;
	
	public WeatherDTO() {
		
	}
	
	public WeatherDTO(Weather obj) {
		this.main = obj.getMain();
		this.description = obj.getDescription();
		this.icon = obj.getIcon();
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
