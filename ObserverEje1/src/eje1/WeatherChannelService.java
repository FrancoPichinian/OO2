package eje1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class WeatherChannelService implements ClimaOnline {

	private static final String URL = "https://api.openweathermap.org/data/2.5/weather?q=viedma,032&units=metric&lang=sp&APPID=";
	private static final String MSG = "Error al consumir API...";
	private String apiKey;

	public WeatherChannelService(String apiKey) {
		this.apiKey = Objects.requireNonNull(apiKey);
	}

	@Override
	public String temperatura() {
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL + apiKey)).build();
		HttpResponse<String> response;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(MSG);
		}
		String jsonString = response.body();
		Gson gson = new GsonBuilder().create();
		JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
		return jsonObject.getAsJsonObject("main").getAsJsonObject().get("temp").toString();
	}
}
