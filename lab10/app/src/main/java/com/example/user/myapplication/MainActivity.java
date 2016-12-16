package com.example.user.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(MainActivity.this,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION) !=PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                googleMap.setMyLocationEnabled(true);

                MarkerOptions m1 = new MarkerOptions();
                m1.position(new LatLng(25.033611,121.565000));
                m1.title("台北101");
                m1.draggable(true);
                googleMap.addMarker(m1);

                MarkerOptions m2 = new MarkerOptions();
                m2.position(new LatLng(25.047924,121.517081));
                m2.title("台北車站");
                m2.draggable(true);
                googleMap.addMarker(m2);

                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.add(new LatLng(25.033611,121.565000));
                polylineOptions.add(new LatLng(25.032728,121.565137));
                polylineOptions.add(new LatLng(25.033739,121.527886));
                polylineOptions.add(new LatLng(25.038716,121.517758));
                polylineOptions.add(new LatLng(25.045656,121.519636));
                polylineOptions.add(new LatLng(25.046200,121.517533));
                polylineOptions.color(Color.BLUE);
                Polyline polyline = googleMap.addPolyline(polylineOptions);
                polyline.setWidth(10);

                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(25.03379,121.527886),11));
            }
        });
    }
}
