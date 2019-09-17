package com.example.locationdemo;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    EditText latitude, longitude;
    Button mark, markCurrent;
    double lati = 28.644800, longi = 77.216721;


    private GoogleMap mMap;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLocationPermission();
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        try {
            mapFragment.getMapAsync(this);
        } catch (Exception e) {

        }
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        client = LocationServices.getFusedLocationProviderClient(this);
        mark = findViewById(R.id.mark);
        markCurrent = findViewById(R.id.markCurrent);
        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    lati = Double.parseDouble(latitude.getText().toString());
                    longi = Double.parseDouble(longitude.getText().toString());
                    LatLng point = new LatLng(lati, longi);
                    mMap.addMarker(new MarkerOptions().position(point).title("This is " + lati + " , " + longi));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point,15));
                } catch (Exception e) {

                }


            }
        });
        markCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            lati = location.getLatitude();
                            latitude.setText(lati+"");
                            longi = location.getLongitude();
                            longitude.setText(longi+"");

                        }
                    });

                    LatLng point = new LatLng(lati, longi);
                    mMap.addMarker(new MarkerOptions().position(point).title("This is current location " + lati + " , " + longi));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 17));

                } catch (Exception e) {

                }


            }
        });
    }

    private void getLocationPermission() {

        ActivityCompat.requestPermissions(this,
                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                1);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng delhi = new LatLng(lati, longi);
        mMap.addMarker(new MarkerOptions().position(delhi).title("Marker in New Delhi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));
    }


}
