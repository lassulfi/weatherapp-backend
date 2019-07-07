package com.weatherapp.services;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Forecast> getWeatherForecast(String cityName) throws WeathermapException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			WeathermapResult result = restTemplate.getForObject(this.getApiAddress(cityName), WeathermapResult.class);

			return result.getList().stream().filter(res -> res.getDt_txt().contains("00:00:00")).collect(Collectors.toList());
			
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
