package httpClient;

import com.maps.project.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ridwan-p on 4/16/16.
 */
public class GoogleAddress extends MHttpClient {

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?key="+ R.string.google_maps_key+"&address=";

    public GoogleAddress() {
        super(BASE_URL);
    }
}
