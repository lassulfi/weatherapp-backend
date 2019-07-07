package com.weatherapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Forecast {

	private List<Weather> weather;
	private String dt_txt;
	
	public Forecast() {
		
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Forecast [list=");
		builder.append(weather);
		builder.append(" date=");
		builder.append(dt_txt);
		builder.append("]");
		return builder.toString();
	}
}
