package com.weatherapp.dto;

import java.io.Serializable;

import com.weatherapp.domain.City;

public class CityDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	public CityDTO() {
		super();
	}
	
	public CityDTO(City obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
