package com.maps.project;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap map_;
    public static final int LOGIN_CODE = 203;
    private boolean isLogin_ = false;
    private GPSTracker gps_;


    private void login()
    {
        if (!isLogin_)
        {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, LOGIN_CODE);
        }

//        loc = new Location();
        //Log.d("status",loc.getStatus("sleman"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        login();
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        map_ = googleMap;
        gps_ = new GPSTracker(MapsActivity.this);
        LatLng loc;
        if (gps_.canGetLocation())
        {
            loc = new LatLng(gps_.getLatitude(), gps_.getLongitude());
//            map_.addMarker(new MarkerOptions().position(loc).title("Posisisku"));
        } else
        {
            loc = new LatLng(-34, 151);
//            map_.addMarker(new MarkerOptions().position(loc).title("Marker in Sydney"));
        }
        // Add a marker in Sydney and move the camera

        map_.addMarker(new MarkerOptions().position(loc).title("PosisiKU"));
        map_.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOGIN_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                isLogin_ = data.getBooleanExtra("login", true);
                Log.d("login", String.valueOf(isLogin_));
            } else if (resultCode == RESULT_CANCELED)
            {
                finish();
            }
        }
    }

    public void btnGoOnClick(View view)
    {

    }
}
