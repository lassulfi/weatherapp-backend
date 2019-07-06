package com.weatherapp.services;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weatherapp.domain.Forecast;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeathermapServiceTest {

	@Autowired
	private WeathermapService weathermapService;
	
	@Test
	public void mustReturnTheForecastForAValidCity() {
		String city = "London";
		
		Forecast result = weathermapService.getWeatherForecast(city);
		
		System.out.println(result);
		
		Assert.assertThat(result.getWeather(), Matchers.notNullValue());
	}
}
