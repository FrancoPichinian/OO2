package ar.unrn;

public class Main {

	private static final String URL = "https://api.openweathermap.org/data/2.5/weather?q=viedma,032&units=metric&lang=en&APPID=";
	private static final String API_KEY = "8b52d3671b3d18440fe95365c2e6b289";

	public static void main(String[] args) {
		var weather = new CachedWeather(new HttpWeather(URL, API_KEY));

		long start = System.currentTimeMillis();
		WeatherData weatherData = weather.weather();
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000f);

		System.out.println(weatherData);

		long start1 = System.currentTimeMillis();
		WeatherData weatherData2 = weather.weather();
		long end1 = System.currentTimeMillis();
		System.out.println((end1 - start1) / 1000f);
		System.out.println(weatherData2);
	}
}
