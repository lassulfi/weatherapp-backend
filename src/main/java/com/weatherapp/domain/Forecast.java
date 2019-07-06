package com.weatherapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Forecast {

	private List<Weather> weather;
	
	public Forecast() {
		
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Forecast [list=");
		builder.append(weather);
		builder.append("]");
		return builder.toString();
	}
}
