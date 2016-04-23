package json.data;

/**
 * Created by suryaramadhon on 4/23/16.
 */
public class OpenWeather extends JsonData{
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public OpenWeather(String url) {
        super(url);
    }
    public OpenWeather(){super(BASE_URL);}
}
