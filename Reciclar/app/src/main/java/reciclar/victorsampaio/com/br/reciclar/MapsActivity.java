package reciclar.victorsampaio.com.br.reciclar;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap, mapEcoPointVarjota, mapEcoPointConjuntoCeara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapEcoPointVarjota = googleMap;
        mapEcoPointConjuntoCeara = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng fortaleza = new LatLng(-3.7543317, -38.5728786);
        //mMap.addMarker(new MarkerOptions().position(fortaleza).title("Marker in FORTALEZA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fortaleza));

        LatLng varjota = new LatLng(-3.731124, -38.483022);
        mapEcoPointVarjota.addMarker(new MarkerOptions().position(varjota).title("Ecoponto Varjota"));

        LatLng conjuntoCeara = new LatLng(-3.772846, -38.542742);
        mapEcoPointConjuntoCeara.addMarker(new MarkerOptions().position(conjuntoCeara).title("Ecoponto Conjunto Ceará"));
        //mMap1.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        // Other supported types include: MAP_TYPE_NORMAL,
        // MAP_TYPE_TERRAIN, MAP_TYPE_HYBRID and MAP_TYPE_NONE
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
}
