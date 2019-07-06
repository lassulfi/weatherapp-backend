package com.weatherapp.services;

import static org.hamcrest.Matchers.is;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.weatherapp.domain.Forecast;
import com.weatherapp.services.exceptions.WeathermapException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WeathermapServiceTest {

	@Autowired
	private WeathermapService weathermapService;
	
	@Test
	public void mustReturnTheForecastForAValidCity() throws WeathermapException {
		String city = "London";
		
		List<Forecast> result = weathermapService.getWeatherForecast(city, 5);
		
		Assert.assertThat(result, Matchers.notNullValue());
	}
	
	@Test(expected = WeathermapException.class)
	public void mustReturnErrorIfCityIsNotValid() throws WeathermapException {
		String city = "Lodona";
		
		List<Forecast> result = weathermapService.getWeatherForecast(city, 5);
	}
	
	@Test
	public void mustReturnTrueIfCityIsValid() {
		String validName = "London";
		
		boolean result = weathermapService.isCityValid(validName);
		
		Assert.assertThat(result, is(true));
	}
	
	@Test
	public void mustReturnFalseIfCityIsInvalid() {
		String invalidName = "Londona";
		
		boolean result = weathermapService.isCityValid(invalidName);
		
		Assert.assertThat(result, is(false));
	}
}
