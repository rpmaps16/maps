package json.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/autocomplete/json?types=geocode&language=id&key=AIzaSyAUiXn6eIhcLSWAxX1VXa735QKDYl3l2aI&input=";
    private ArrayList<AutoComplete> data;
    public GoogleAutoComplete(String url) {
        super(url);
    }
    public GoogleAutoComplete(){super(BASE_URL);}
    public GoogleAutoComplete(Context context){
        super(BASE_URL);
        requestQueue = Volley.newRequestQueue(context);
    }
    public ArrayList<AutoComplete > getPrediction(final String loc){
        data=new ArrayList<AutoComplete>();
        objectRequest= new JsonObjectRequest(Request.Method.GET, BASE_URL + loc, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
//                    Log.d("url",BASE_URL+loc);
                    jsonArray=response.getJSONArray("predictions");
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject des=jsonArray.getJSONObject(i);
                        //Log.d("des :",des.getString("description"));
                        AutoComplete value=new AutoComplete(des.getString("description"),des.getString("id"),des.getString("place_id"));
                        Log.d("des ",value.getDescription());
                        data.add(value);
                    }
//                    Log.d("tss",response.toString())
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
