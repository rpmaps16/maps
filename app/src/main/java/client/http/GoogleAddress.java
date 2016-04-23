package client.http;

import com.maps.project.R;

/**
 * Created by ridwan-p on 4/16/16.
 */
public class GoogleAddress extends MHttpClient
{

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?key=" + R.string.google_maps_key + "&address=";

    public GoogleAddress()
    {
        super(BASE_URL);
    }
}
