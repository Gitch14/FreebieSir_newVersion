package com.example.freebiesir;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private GoogleMap mMap;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {



        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng kzi = new LatLng(46.48044796386659, 30.73473057318427);

            googleMap.addMarker(new MarkerOptions().position(kzi).title("KZI").visible(false));




            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kzi, 15));
            googleMap.addMarker(new MarkerOptions()
                    .position(kzi)
                    .title("kzi")
                    .visible(false));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.48044796386659, 30.73473057318427))
                    .title("KZI")
                    .snippet("KZI")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .visible(false));


            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.46809111660394, 30.72615899632388))
                    .title("ТАВРИЯ В")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .visible(App.getInstance(false)));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.479354989784575, 30.721792264675024))
                    .title("ТАВРИЯ В")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .visible(App.getInstance()));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.48271965560669, 30.735735123043714))
                    .title("ТАВРИЯ В")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .visible(App.getInstance(false)));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.480576895416625, 30.74488336644908))
                    .title("ТАВРИЯ В")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .visible(App.getInstance(false)));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.483863944792816, 30.737642270592833))
                    .title("ТАВРИЯ В")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .visible(App.getInstance(false)));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.482013297695424, 30.7320224757837))
                    .title("ТАВРИЯ В")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .visible(App.getInstance(false)));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.470286912004106, 30.71708716395237))
                    .title("КОПЕЙКА")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                    .visible(App1.getInstance(false)));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.47280659752476, 30.71215189945036))
                    .title("КОПЕЙКА")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                    .visible(App1.getInstance(true)));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng( 46.46838044481153, 30.71899689652372))
                    .title("КОПЕЙКА")
                    .snippet("Кликните что бы перейти в католог)")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                    .visible(App1.getInstance()));

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}