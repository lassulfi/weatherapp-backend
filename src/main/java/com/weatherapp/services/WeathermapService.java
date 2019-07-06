package com.weatherapp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherapp.domain.Forecast;

/**
 * Service class for retrieving data from the wheatermap api
 * @author LuisDaniel
 *
 */
@Service
public class WeathermapService {
	
	@Value("${appid}")
	private String appId;
	
	private String getApiAddress(String cityName) {
		return "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + appId;
	}
	
	public Forecast getWeatherForecast(String cityName) {
		
		RestTemplate restTemplate = new RestTemplate();
		Forecast forecast = restTemplate.getForObject(this.getApiAddress(cityName), Forecast.class);
		
		return forecast;
	}
}
