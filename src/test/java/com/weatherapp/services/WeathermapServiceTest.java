package com.weatherapp.services;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weatherapp.domain.Forecast;
import com.weatherapp.services.exceptions.WeathermapException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeathermapServiceTest {

	@Autowired
	private WeathermapService weathermapService;
	
	@Test
	public void mustReturnTheForecastForAValidCity() throws WeathermapException {
		String city = "London";
		
		Forecast result = weathermapService.getWeatherForecast(city);
		
		Assert.assertThat(result.getWeather(), Matchers.notNullValue());
	}
	
	@Test(expected = WeathermapException.class)
	public void mustReturnErrorIfCityIsNotValid() throws WeathermapException {
		String city = "Lodona";
		
		Forecast result = weathermapService.getWeatherForecast(city);
		
		System.out.println(result);
	}
}
