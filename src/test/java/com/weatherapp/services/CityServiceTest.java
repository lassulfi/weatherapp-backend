package com.weatherapp.services;

import static org.hamcrest.Matchers.notNullValue;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.weatherapp.domain.City;
import com.weatherapp.repositories.CityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CityServiceTest {

	@MockBean
	private CityRepository cityRepository;
	
	@InjectMocks
	private WeathermapService weatherService;
	
	@Autowired
	private CityService cityService;
	
	private static final String NAME = "London";
	
	private static final String ID = "zdO1jU0ARs";
	
	@Before
	public void setup() throws Exception {
		BDDMockito.given(this.cityRepository.findById(ID)).willReturn(Optional.of(new City(ID, NAME)));
		BDDMockito.given(this.cityRepository.save(Mockito.any(City.class))).willReturn(new City());
	}
	
	@Test
	public void testPersistCity() {
		City city = this.cityService.insert(new City(null, NAME));
		
		Assert.assertThat(city, notNullValue());
	}
	
	@Test
	public void testFindCityById() {
		City obj = this.cityService.findById(ID);
		
		Assert.assertThat(obj, notNullValue());
	}
	
}
