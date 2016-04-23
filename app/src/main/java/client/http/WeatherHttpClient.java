package client.http;

/**
 * Created by ridwan-p on 4/16/16.
 */
public class WeatherHttpClient extends MHttpClient
{
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public WeatherHttpClient()
    {
        super(BASE_URL);
    }
}
