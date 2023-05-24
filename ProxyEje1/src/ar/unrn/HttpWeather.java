package ar.unrn;

import java.io.IOException;
import java.util.Objects;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpWeather implements Weather {

	private String url;
	private String apiKey;

	public HttpWeather(String url, String apiKey) {
		this.url = Objects.requireNonNull(url);
		this.apiKey = Objects.requireNonNull(apiKey);
	}

	public WeatherData weather() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url + apiKey).build();
		try (Response response = client.newCall(request).execute()) {
			String jsonData = Objects.requireNonNull(response.body()).string();
			JSONObject weatherJson = new JSONObject(jsonData);
			String city = weatherJson.get("name").toString();
			String temperature = weatherJson.getJSONObject("main").get("temp").toString();
			String description = weatherJson.getJSONArray("weather").getJSONObject(0).get("description").toString();
			return new WeatherData(city, temperature, description);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
