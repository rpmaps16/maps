package json.data;

/**
 * Created by suryaramadhon on 4/23/16.
 */
public class GoogleWeather extends JsonData{
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public GoogleWeather(String url) {
        super(url);
    }
    public GoogleWeather(){super(BASE_URL);}
}
