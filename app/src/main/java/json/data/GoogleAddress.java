package json.data;

import com.maps.project.R;

/**
 * Created by suryaramadhon on 4/23/16.
 */
public class GoogleAddress extends JsonData{
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?key=" + R.string.google_maps_key + "&address=";

    public GoogleAddress(String url) {

        super(url);

    }
    public GoogleAddress(){super(BASE_URL);}
}
