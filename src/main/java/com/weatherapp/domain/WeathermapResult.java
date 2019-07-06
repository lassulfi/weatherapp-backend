package com.weatherapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeathermapResult {

	private List<Forecast> list;
	
	public WeathermapResult() {
		
	}

	public List<Forecast> getList() {
		return list;
	}

	public void setList(List<Forecast> list) {
		this.list = list;
	}
}
