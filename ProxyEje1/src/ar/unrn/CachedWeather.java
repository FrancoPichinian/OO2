package ar.unrn;

import java.time.LocalDateTime;
import java.util.Objects;

public class CachedWeather implements Weather {

	private Weather weatherReal;
	private WeatherData cachedData;
	private LocalDateTime cachedTime;

	public CachedWeather(Weather weatherReal) {
		this.weatherReal = Objects.requireNonNull(weatherReal);
		this.cachedTime = LocalDateTime.now();
	}

	@Override
	public WeatherData weather() {
		if (cachedData != null && LocalDateTime.now().isBefore(this.cachedTime.plusMinutes(30)))
			return cachedData;
		cachedData = this.weatherReal.weather();
		return cachedData;
	}
}