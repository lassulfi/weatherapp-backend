package com.weatherapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.weatherapp.domain.Forecast;
import com.weatherapp.domain.WeathermapResult;
import com.weatherapp.services.exceptions.WeathermapException;

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
		return "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + appId + "&lang=pt";
	}
	
	public List<Forecast> getWeatherForecast(String cityName, int numberOfDays) throws WeathermapException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			WeathermapResult result = restTemplate.getForObject(this.getApiAddress(cityName), WeathermapResult.class);
			
			List<Forecast> fiveDayResult = new ArrayList<>();
			if(numberOfDays < result.getList().size()) {
				for(int i = 0; i < numberOfDays; i++) {
					fiveDayResult.add(result.getList().get(i));
				}
				return fiveDayResult;
			} else {
				return result.getList();
			}
			
		} catch (HttpClientErrorException e) {
			throw new WeathermapException("Não foi possível encontrar cidade com nome " + cityName);
		}
	}
	
	public boolean isCityValid(String name) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			restTemplate.getForObject(this.getApiAddress(name), Forecast.class);
			
			return true;
		} catch (HttpClientErrorException e) {
			return false;
		}
	}
}
