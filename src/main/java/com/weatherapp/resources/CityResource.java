package com.weatherapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.weatherapp.domain.City;
import com.weatherapp.dto.CityDTO;
import com.weatherapp.dto.ForecastDTO;
import com.weatherapp.services.CityService;

@RestController
@RequestMapping(value="/cidades")
@CrossOrigin(origins = "*")
public class CityResource {

	@Autowired
	private CityService cityService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> findAll() {
		List<City> list = this.cityService.findAll();
		List<CityDTO> listDTO = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ForecastDTO> findById(@PathVariable String id) {
		City cityObj = this.cityService.findById(id);
		
		return ResponseEntity.ok().body(new ForecastDTO(cityObj));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CityDTO objDTO) {
		City obj = this.cityService.fromDTO(objDTO);
		
		obj = this.cityService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "{/id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(String id) {
		this.cityService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
