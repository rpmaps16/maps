package json.data;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by suryaramadhon on 4/23/16.
 */
public class JsonData {

    protected RequestQueue requestQueue;
    protected JsonObjectRequest objectRequest;
    protected JSONObject jsonObject;
    protected JSONArray jsonArray;
    protected String url;
    public JsonData(String url){
        this.url=url;
    }
}
