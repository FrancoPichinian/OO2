package ar.unrn;

import java.util.Objects;

public class WeatherData {

	private String city;
	private String temperature;
	private String description;

	public WeatherData(String city, String temperature, String description) {
		this.city = Objects.requireNonNull(city);
		this.temperature = Objects.requireNonNull(temperature);
		this.description = Objects.requireNonNull(description);
	}

	@Override
	public String toString() {
		return "WeatherData [city=" + city + ", temperature=" + Double.valueOf(temperature).intValue() + " grados"
				+ ", description=" + description + "]";
	}
}
