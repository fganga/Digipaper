package DTO;

public class Solicitud {

    private int solicitudId;
    private String solicitudNombre;
    private String solicitudDescripcion;
    private String solicitudObservaciones;
    private int usuarioId;
    private int empleadoId;
    private int municipioId;

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


    public String getSolicitudDescripcion() {
        return solicitudDescripcion;
    }

    public void setSolicitudDescripcion(String solicitudDescripcion) {
        this.solicitudDescripcion = solicitudDescripcion;
    }

    public String getSolicitudObservaciones() {
        return solicitudObservaciones;
    }

    public void setSolicitudObservaciones(String solicitudObservaciones) {
        this.solicitudObservaciones = solicitudObservaciones;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public int getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(int municipioId) {
        this.municipioId = municipioId;
    }
}