package com.weatherapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Weather {
	
	private String main;
	private String description;
	private String icon;
	
	public Weather() {
		
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Weather [main=");
		builder.append(main);
		builder.append(", description=");
		builder.append(description);
		builder.append(", icon=");
		builder.append(icon);
		builder.append("]");
		return builder.toString();
	}
}
