package json.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.maps.project.AutoComplete;
import com.maps.project.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by suryaramadhon on 4/23/16.
 */
public class GoogleAutoComplete extends JsonData {
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/autocomplete/json?types=geocode&language=id&key="+ R.string.google_maps_key+"&input=";

    public GoogleAutoComplete(String url) {
        super(url);
    }
    public GoogleAutoComplete(){super(BASE_URL);}

    public ArrayList<AutoComplete > getPrediction(String loc){
        final ArrayList<AutoComplete> data=new ArrayList<AutoComplete>();
        objectRequest= new JsonObjectRequest(Request.Method.GET, BASE_URL + loc, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    jsonArray=response.getJSONArray("prediction");

                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject des=jsonArray.getJSONObject(i);
                        AutoComplete value=new AutoComplete(des.getString("description"),des.getString("id"),des.getString("place_id"));
                        data.add(value);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(objectRequest);
        return data;
    }

}
