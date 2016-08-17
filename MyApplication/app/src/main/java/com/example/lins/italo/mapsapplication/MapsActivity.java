package com.example.lins.italo.mapsapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMapClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the Map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        // campina grande (-7.227384, -35.884497)

        LatLng position = new LatLng(-7.227384, -35.884497);

        final CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(position)   // onde a camera ta apontando
                .bearing(130)       // direção em graus da camera
                .tilt(0)            // angulo em graus
                .zoom(17)           // zoom
                .build();

        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

        mMap.animateCamera(cameraUpdate);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(position).title("Marker in Campina Grande");
        mMap.addMarker(markerOptions);

        //mMap.addMarker(new MarkerOptions().position(position).title("Marker in Campina Grande"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
    }


    @Override
    public void onMapClick(LatLng latLng) {
        TextView tDebug = (TextView) findViewById(R.id.tdebug);
        CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
        tDebug.setText("Posição: " + latLng);
//		Toast.makeText(getBaseContext(), "Click: " + latLng, Toast.LENGTH_SHORT).show();
//		map.animateCamera(update);
    }
}
