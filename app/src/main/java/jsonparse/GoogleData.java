package jsonparse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import httpClient.GoogleAddress;
import httpClient.GoogleLocationAutoComplete;
import httpClient.GooglePlace;

/**
 * Created by ridwan-p on 4/16/16.
 */
public class GoogleData {

    private String location_;
    private GoogleLocationAutoComplete locAutoComplete_;
    private GoogleAddress googleAddress_;
    private GooglePlace googlePlace_;
    private JSONObject jsonObject_;
    private JSONArray jsonArray_;

    public GoogleData(String loc)
    {
        location_ = loc;
    }
    public GoogleData()
    {
        location_ = null;
    }
    public void setLocation(String loc)
    {
        location_ = loc;
    }

    //////////////////////////////////////////////////////////////////////////
    public double getLatitude()
    {
        try {
            JSONObject geo = getGeometry();
            return geo.getJSONObject("location").getDouble("lat");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public double getLongitude()
    {
        try {
            JSONObject geo = getGeometry();
            return geo.getJSONObject("location").getDouble("lng");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public String getFormatAddress()
    {
        try {
            JSONArray result = getResult();

            return result.getJSONObject(0).getString("formatted_address");
        }   catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public ArrayList<String> getPredictionsDescription()
    {
        ArrayList<String> data = new ArrayList<String>();

        JSONArray predic = getPredictions();

        for(int i = 0; i < predic.length(); ++i)
        {
            try {
                JSONObject des  = predic.getJSONObject(i);
                String value = des.getString("description");
                data.add(value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return data;

    }

//////////////////////////////////Method private//////////////////////////////////////////
    private JSONArray getResult()
    {
        try {
            jsonObject_ = new JSONObject(googleAddress_.getData(location_));
            return jsonObject_.getJSONArray("result");
        }   catch (JSONException e) {
            e.printStackTrace();
        }
            return  null;

    }
    private JSONObject getGeometry()
    {
        try {
            JSONArray result = getResult();
            return result.getJSONObject(0).getJSONObject("geometry");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }
    private JSONArray getPredictions()
    {
        try {
            jsonObject_ = new JSONObject(locAutoComplete_.getData(location_));
            return jsonObject_.getJSONArray("predictions");
        }   catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
