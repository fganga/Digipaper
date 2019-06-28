package inacaptemuco.com.digipaperfinal;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import DTO.EstadoSolicitud;
import DTO.SolicitudReporte;
import DTO.SolicitudReporteAdapter;
import Utilidades.Mensajeria;

import static inacaptemuco.com.digipaperfinal.Login.token;
import static inacaptemuco.com.digipaperfinal.Login.txvUserToken;

public class Historial extends AppCompatActivity implements SolicitudReporteAdapter.OnItemClickListener {

    private RecyclerView rcvSolicitud;

    private SolicitudReporteAdapter adpSolicitudReporte;

    private ArrayList<SolicitudReporte> arlSolicitudReporte;

    private Mensajeria mensajeria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        Intent intent = getIntent();
        String token = intent.getStringExtra("token");


        obtenerDatosSolicitud();
        rcvSolicitud = (RecyclerView) findViewById(R.id.rcv_historial);
        rcvSolicitud.setLayoutManager(new LinearLayoutManager(this));
        arlSolicitudReporte = new ArrayList<>();
        adpSolicitudReporte = new SolicitudReporteAdapter(this, arlSolicitudReporte);


        rcvSolicitud.setAdapter(adpSolicitudReporte);


    }


    public void obtenerDatosSolicitud() {

        if (token == null || token == "") {
            mensajeria = new Mensajeria("No existe Token", getApplicationContext());
            return;

        }

        Ion.with(this)
                .load("GET", "https://www.digipaper.online/api/solicitudes")
                .setHeader("Authorization", "Bearer " + token)
                .as(new TypeToken<ArrayList<SolicitudReporte>>() {
                })
                .setCallback(new FutureCallback<ArrayList<SolicitudReporte>>() {
                    @Override
                    public void onCompleted(Exception e, ArrayList<SolicitudReporte> result) {
                        if (e != null) {
                            //Llamamos a la utilidad de mensalería en el contexto actual
                            new Mensajeria(e.getMessage(), getApplicationContext());

                            return;

                        } else {

                            arlSolicitudReporte.addAll(result);
                            adpSolicitudReporte.notifyDataSetChanged();
                            //Llamamos a la utilidad de mensalería en el contexto actual desde su método (void)
                            new Mensajeria("Datos Encontrados!", getApplicationContext());
                        }
                    }

                });

    }


    @Override
    public void onItemClick(int position) {
        arlSolicitudReporte.get(position);
        obtenerDatosSolicitud();
        Intent intentDetalleSolicitud = new Intent(Historial.this, DetalleSolicitud.class);
        for(int i = 0; i < arlSolicitudReporte.size();i++) {
            intentDetalleSolicitud.putExtra("id", arlSolicitudReporte.get(i).getSolicitudId());
            intentDetalleSolicitud.putExtra("nombre", arlSolicitudReporte.get(i).getSolicitudNombre());
            intentDetalleSolicitud.putExtra("observaciones", arlSolicitudReporte.get(i).getObservacionesSolicitudes());
        }
        startActivity(intentDetalleSolicitud);

    }
}


