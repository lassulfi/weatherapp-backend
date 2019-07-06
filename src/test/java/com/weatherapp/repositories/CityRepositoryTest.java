package com.weatherapp.repositories;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.weatherapp.domain.City;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CityRepositoryTest {
	
	@Autowired
	private CityRepository repository;
	
	private static final String NAME = "London";
	private static final String ID = "zdO1jU0ARs";
	
	@Before
	public void setup() {
		City city = new City();
		city.setName(NAME);
		city.setId(ID);
		
		this.repository.save(city);
	}
	
	@After
	public final void tearDown() {
		this.repository.deleteAll();
	}
	
	@Test
	public void testFindByName() {
		Optional<City> city = repository.findById(ID);
		
		Assert.assertThat(city.get(), Matchers.notNullValue());
	}

}
