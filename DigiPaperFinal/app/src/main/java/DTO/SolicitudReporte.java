package DTO;

public class SolicitudReporte {

    private int solicitudId;
    private String solicitudNombre;
    private String observacionesSolicitudes;
    private int idEmpleado;
    private int idMunicipio;
    private int idSolicitante;
    private int idEstadoSolicitud;

    public SolicitudReporte(int solicitudId, String solicitudNombre, String observacionesSolicitudes, int idEmpleado, int idMunicipio, int idSolicitante, int idEstadoSolicitud) {
        this.solicitudId = solicitudId;
        this.solicitudNombre = solicitudNombre;
        this.observacionesSolicitudes = observacionesSolicitudes;
        this.idEmpleado = idEmpleado;
        this.idMunicipio = idMunicipio;
        this.idSolicitante = idSolicitante;
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    public int getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getSolicitudNombre() {
        return solicitudNombre;
    }

    public void setSolicitudNombre(String solicitudNombre) {
        this.solicitudNombre = solicitudNombre;
    }

    public String getObservacionesSolicitudes() {
        return observacionesSolicitudes;
    }

    public void setObservacionesSolicitudes(String observacionesSolicitudes) {
        this.observacionesSolicitudes = observacionesSolicitudes;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public int getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }

    public void setIdEstadoSolicitud(int idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }
}

