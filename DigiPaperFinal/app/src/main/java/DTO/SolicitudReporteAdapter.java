package DTO;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import inacaptemuco.com.digipaperfinal.DetalleSolicitud;
import inacaptemuco.com.digipaperfinal.Historial;
import inacaptemuco.com.digipaperfinal.R;

public class SolicitudReporteAdapter extends RecyclerView.Adapter<SolicitudReporteHolder>{

    Context context;
    ArrayList<SolicitudReporte> solicitudes;
    private OnItemClickListener mListener;

    public SolicitudReporteAdapter(Context context, ArrayList<SolicitudReporte> solicitudes){
        this.context=context;
        this.solicitudes=solicitudes;

    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    @NonNull
    @Override
    public SolicitudReporteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_historial,viewGroup, false);
        return new SolicitudReporteHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SolicitudReporteHolder solicitudReporteHolder, int i) {
        SolicitudReporte solicitudReporte = solicitudes.get(i);
        solicitudReporteHolder.definirDetallesSolicitudes(solicitudReporte);
        if(solicitudReporte.getIdEstadoSolicitud()==3){
            solicitudReporteHolder.itemView.setBackgroundColor(Color.RED);
        }
        else if(solicitudReporte.getIdEstadoSolicitud()==2){
            solicitudReporteHolder.itemView.setBackgroundColor(Color.GREEN);
        }else{
            solicitudReporteHolder.itemView.setBackgroundColor(Color.YELLOW);
        }

    }


    @Override
    public int getItemCount() {
        return solicitudes.size();
    }


}

class SolicitudReporteHolder extends RecyclerView.ViewHolder{

    Context context;
    private TextView txvIdSolicitud, txvNombreSolicitud, txvEstadoSilicitud;
    public ImageView imvMoreInfo;

    public SolicitudReporteHolder(@NonNull View itemView){
        super(itemView);
        context = itemView.getContext();

        txvIdSolicitud    = itemView.findViewById(R.id.txv_id_solicitud);
        txvNombreSolicitud = itemView.findViewById(R.id.txv_nombre_solicitud);
        txvEstadoSilicitud = itemView.findViewById(R.id.txv_estado_solicitud);
        imvMoreInfo  = itemView.findViewById(R.id.imv_more_info);


    }

    public void definirDetallesSolicitudes(SolicitudReporte solicitudReporte){
        txvIdSolicitud.setText("Numero: "+ solicitudReporte.getSolicitudId());
        txvNombreSolicitud.setText("Nombre: "+solicitudReporte.getSolicitudNombre());



        ArrayList<EstadoSolicitud> arlEstadoSolicitud = new ArrayList<>();

        int estadoSolicitudId = 0;
        String estadoSolicitudNombre = "";

        EstadoSolicitud estadoSolicitud = new EstadoSolicitud(estadoSolicitudId, estadoSolicitudNombre);
        estadoSolicitud.setEstadoSolicitudId(1);
        estadoSolicitud.setEstadoSolicitudNombre("Pendiente");
        arlEstadoSolicitud.add(estadoSolicitud);
        estadoSolicitud = new EstadoSolicitud(estadoSolicitudId, estadoSolicitudNombre);
        estadoSolicitud.setEstadoSolicitudId(2);
        estadoSolicitud.setEstadoSolicitudNombre("Aprobado");
        arlEstadoSolicitud.add(estadoSolicitud);
        estadoSolicitud = new EstadoSolicitud(estadoSolicitudId, estadoSolicitudNombre);
        estadoSolicitud.setEstadoSolicitudId(3);
        estadoSolicitud.setEstadoSolicitudNombre("Rechazado");
        arlEstadoSolicitud.add(estadoSolicitud);

        for(int i = 0; i < arlEstadoSolicitud.size();i++){
            if(arlEstadoSolicitud.get(i).getEstadoSolicitudId() == solicitudReporte.getIdEstadoSolicitud()){

                txvEstadoSilicitud.setText ("Estado: "+arlEstadoSolicitud.get(i).getEstadoSolicitudNombre());
                break;
            }

        }

    }




}