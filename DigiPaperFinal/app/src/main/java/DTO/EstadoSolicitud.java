package DTO;

public class EstadoSolicitud {

    private int estadoSolicitudId;
    private String estadoSolicitudNombre;

    public EstadoSolicitud(int estadoSolicitudId, String estadoSolicitudNombre) {
        this.estadoSolicitudId = estadoSolicitudId;
        this.estadoSolicitudNombre = estadoSolicitudNombre;
    }

    public int getEstadoSolicitudId() {
        return estadoSolicitudId;
    }

    public void setEstadoSolicitudId(int estadoSolicitudId) {
        this.estadoSolicitudId = estadoSolicitudId;
    }

    public String getEstadoSolicitudNombre() {
        return estadoSolicitudNombre;
    }

    public void setEstadoSolicitudNombre(String estadoSolicitudNombre) {
        this.estadoSolicitudNombre = estadoSolicitudNombre;
    }
}
