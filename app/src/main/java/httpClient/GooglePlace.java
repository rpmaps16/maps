package httpClient;

import com.maps.project.R;

/**
 * Created by ridwan-p on 4/16/16.
 */
public class GooglePlace extends MHttpClient {

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?key="+ R.string.google_maps_key+"&place_id=";

    public GooglePlace() {
        super(BASE_URL);
    }
}
