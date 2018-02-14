package reciclar.victorsampaio.com.br.reciclar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import reciclar.victorsampaio.com.br.reciclar.adapter.ImageAdapter;

/**
 * @version Inicial developer branch
 */

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.relativeMap)
    RelativeLayout relativeMap;
    Toolbar toolbar;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.realtive_recycle_tips)
    RelativeLayout relativeRecycleTips;
    @BindView(R.id.realtive_contacts)
    RelativeLayout relativeContacts;

    SupportMapFragment mapFragment;

    private GoogleMap mMap, ecoPointVarjota, ecoPointConjuntoCeara, ecoPGuararapes,
            ecoPAdvogadoMarcoAntonioForte, ecoPCidadeDosFuncionários, ecoSaoJoaoTauape, ecoJacarecanga, ecoSerrinha,
            ecoConjEsperanca, ecoFatima, ecoPirambu, ecoVicentePinzon, ecoCarlitoPamplona, ecoSapiranga;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // startMap();
                    Toast.makeText(getApplicationContext(), "Tela 1", Toast.LENGTH_SHORT).show();

                    relativeMap.setVisibility(View.VISIBLE);
                    relativeContacts.setVisibility(View.INVISIBLE);
                    relativeRecycleTips.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    //pauseMap();
                    Toast.makeText(getApplicationContext(), "Tela 2", Toast.LENGTH_SHORT).show();

                    relativeMap.setVisibility(View.INVISIBLE);
                    relativeContacts.setVisibility(View.INVISIBLE);
                    relativeRecycleTips.setVisibility(View.VISIBLE);
                    configScreen();
                    return true;
                case R.id.navigation_notifications:

                    relativeMap.setVisibility(View.INVISIBLE);
                    relativeRecycleTips.setVisibility(View.INVISIBLE);
                    relativeContacts.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Tela 3", Toast.LENGTH_SHORT).show();
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    private void configScreen() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        // BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MapsActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startMap() {
        /*mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapFragment.setMenuVisibility(true);*/
        relativeMap.setVisibility(View.VISIBLE);
        relativeContacts.setVisibility(View.INVISIBLE);
        relativeRecycleTips.setVisibility(View.INVISIBLE);
    }


    private void pauseMap() {
       /* mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
       */
        relativeMap.setVisibility(View.INVISIBLE);
       /* mapFragment.setUserVisibleHint(false);
        mapFragment.setMenuVisibility(false);*/

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
        ecoPointVarjota = googleMap;
        ecoPointConjuntoCeara = googleMap;
        ecoPGuararapes = googleMap;
        ecoPAdvogadoMarcoAntonioForte = googleMap;
        ecoPCidadeDosFuncionários = googleMap;
        ecoSaoJoaoTauape = googleMap;
        ecoJacarecanga = googleMap;
        ecoSerrinha = googleMap;
        ecoConjEsperanca = googleMap;
        ecoFatima = googleMap;
        ecoPirambu = googleMap;
        ecoVicentePinzon = googleMap;
        ecoCarlitoPamplona = googleMap;
        ecoSapiranga = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng fortaleza = new LatLng(-3.7543317, -38.5728786);
        //mMap.addMarker(new MarkerOptions().position(fortaleza).title("Marker in FORTALEZA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fortaleza));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11), 2000, null);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        LatLng varjota = new LatLng(-3.731124, -38.483022);
        ecoPointVarjota.addMarker(new MarkerOptions().position(varjota).title("Ecoponto Varjota"));

        LatLng conjuntoCeara = new LatLng(-3.772846, -38.542742);
        ecoPointConjuntoCeara.addMarker(new MarkerOptions().position(conjuntoCeara).title("Ecoponto Conjunto Ceará"));
        //mMap1.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        // Other supported types include: MAP_TYPE_NORMAL,
        // MAP_TYPE_TERRAIN, MAP_TYPE_HYBRID and MAP_TYPE_NONE

        LatLng guararapes = new LatLng(-3.7543317, -38.5728786);
        ecoPGuararapes.addMarker(new MarkerOptions().position(guararapes).title("Ecoponto Guararapes"));

        LatLng advogadoMarcoAntonioForte = new LatLng(-3.7739257, -38.4753871);
        ecoPAdvogadoMarcoAntonioForte.addMarker(new MarkerOptions().position(advogadoMarcoAntonioForte).title("Ecoponto Advogado MarcoAntonio Forte"));

        LatLng cidadeDosFuncionários = new LatLng(-3.7894688, -38.4919866);
        ecoPCidadeDosFuncionários.addMarker(new MarkerOptions().position(cidadeDosFuncionários).title("Ecoponto Cidade Dos Funcionários"));

        LatLng saoJoaoTauape = new LatLng(-3.7515811, -38.5207439);
        ecoSaoJoaoTauape.addMarker(new MarkerOptions().position(saoJoaoTauape).title("Ecoponto São João do Tauape"));

        LatLng jacarecanga = new LatLng(-3.7515811, -38.5207439);
        ecoJacarecanga.addMarker(new MarkerOptions().position(jacarecanga).title("Ecoponto Jacarecanga"));

        LatLng serrinha = new LatLng(-3.7822994, -38.542956);
        ecoSerrinha.addMarker(new MarkerOptions().position(serrinha).title("Ecoponto Serrinha"));


        LatLng conjEsperança = new LatLng(-3.7515811, -38.5207439);
        ecoConjEsperanca.addMarker(new MarkerOptions().position(conjEsperança).title("Ecoponto Conjunto Esperança"));

        LatLng fatima = new LatLng(-3.7524675, -38.5327908);
        ecoFatima.addMarker(new MarkerOptions().position(fatima).title("Ecoponto Bairro de Fatima"));

        LatLng pirambu = new LatLng(-3.7108772, -38.5530358);
        ecoPirambu.addMarker(new MarkerOptions().position(pirambu).title("Ecoponto Pirambu"));

        LatLng vicentePinzon = new LatLng(-3.7293711, -38.4719875);
        ecoVicentePinzon.addMarker(new MarkerOptions().position(vicentePinzon).title("Ecoponto Vicente Pinzon"));

        LatLng carlitoPamplona = new LatLng(-3.7173684, -38.556275);
        ecoCarlitoPamplona.addMarker(new MarkerOptions().position(carlitoPamplona).title("Ecoponto Carlito Pamplona"));

        LatLng sapiranga = new LatLng(-3.789023, -38.4741398);
        ecoSapiranga.addMarker(new MarkerOptions().position(sapiranga).title("Ecoponto Sapiranga"));



    }
}
