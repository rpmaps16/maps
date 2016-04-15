package com.maps.project;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Created by ridwan-p on 4/15/16.
 */
public class Location {
    private  static final String GEO_LOCATION_ANDDRESS= "https://maps.googleapis.com/maps/api/geocode/json?address=" ;
    private  static final String GEO_LOCATION_PLACEID= "https://maps.googleapis.com/maps/api/geocode/json?place_id=" ;
    private static final String LOC_AUTOCOMPLETE  = "https://maps.googleapis.com/maps/api/place/autocomplete/json?types=geocode&language=id&input=";
    private static final String API_KEY  = "AIzaSyAUiXn6eIhcLSWAxX1VXa735QKDYl3l2aI";
    private String address;
    private double lng;
    private double lat;

    private JSONObject loc_desrip;
//
//    public Location(String add)
//    {
//        address = add;
//    }
//    public Location(double lo, double la)
//    {
//
//    }


    public ArrayList<String> getLocAutocomplete(String addrs)
    {
        return  null;
    }

    public  String getStatus(String addrs)
    {
        String url = LOC_AUTOCOMPLETE+addrs+"&key="+API_KEY;
//        JSONObject json = getJson(url);
//        if(json == null)
//            return "data kosong";
        String status = getJson(url);
        return  status;
    }
    private String getJson(String url)
    {
        try{
            // Create a new HTTP Client
            DefaultHttpClient defaultClient = new DefaultHttpClient();
            // Setup the get request
            HttpGet httpGetRequest = new HttpGet(url);

            // Execute the request in the client
            HttpResponse httpResponse = defaultClient.execute(httpGetRequest);
            // Grab the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            String json = reader.readLine();

            // Instantiate a JSON object from the request response
            JSONObject jsonObject = new JSONObject(json);

            return  json;
        } catch(Exception e){
            // In your production code handle any errors and catch the individual exceptions
            e.printStackTrace();
            return  null;
        }
    }


}
