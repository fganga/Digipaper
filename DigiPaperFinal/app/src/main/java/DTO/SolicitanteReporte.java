package DTO;

import java.util.Date;

public class SolicitanteReporte {
    private int idSolicitante;
            private int rutSolicitante;
            private String nombreSolicitante;
            private String apePatSolicitante;
            private String apeMatSolicitante;
            private Date fechaNacSolicitante;
            private int activoSolicitante;
            private String mailSolicitante;
            private int idMensajes;
            private String fullname;

    public SolicitanteReporte(int idSolicitante, int rutSolicitante, String nombreSolicitante, String apePatSolicitante, String apeMatSolicitante, Date fechaNacSolicitante, int activoSolicitante, String mailSolicitante, int idMensajes, String fullname) {
        this.idSolicitante = idSolicitante;
        this.rutSolicitante = rutSolicitante;
        this.nombreSolicitante = nombreSolicitante;
        this.apePatSolicitante = apePatSolicitante;
        this.apeMatSolicitante = apeMatSolicitante;
        this.fechaNacSolicitante = fechaNacSolicitante;
        this.activoSolicitante = activoSolicitante;
        this.mailSolicitante = mailSolicitante;
        this.idMensajes = idMensajes;
        this.fullname = fullname;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public int getRutSolicitante() {
        return rutSolicitante;
    }

    public void setRutSolicitante(int rutSolicitante) {
        this.rutSolicitante = rutSolicitante;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getApePatSolicitante() {
        return apePatSolicitante;
    }

    public void setApePatSolicitante(String apePatSolicitante) {
        this.apePatSolicitante = apePatSolicitante;
    }

    public String getApeMatSolicitante() {
        return apeMatSolicitante;
    }

    public void setApeMatSolicitante(String apeMatSolicitante) {
        this.apeMatSolicitante = apeMatSolicitante;
    }

    public Date getFechaNacSolicitante() {
        return fechaNacSolicitante;
    }

    public void setFechaNacSolicitante(Date fechaNacSolicitante) {
        this.fechaNacSolicitante = fechaNacSolicitante;
    }

    public int getActivoSolicitante() {
        return activoSolicitante;
    }

    public void setActivoSolicitante(int activoSolicitante) {
        this.activoSolicitante = activoSolicitante;
    }

    public String getMailSolicitante() {
        return mailSolicitante;
    }

    public void setMailSolicitante(String mailSolicitante) {
        this.mailSolicitante = mailSolicitante;
    }

    public int getIdMensajes() {
        return idMensajes;
    }

    public void setIdMensajes(int idMensajes) {
        this.idMensajes = idMensajes;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
