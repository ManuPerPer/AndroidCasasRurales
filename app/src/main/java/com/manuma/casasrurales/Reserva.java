package com.manuma.casasrurales;

import java.io.Serializable;

public class Reserva implements Serializable {

    private String numAdultos;
    private String numNinios;
    private String fechaDesde;
    private String fechaHasta;
    private String tipoAlojamiento;

    public String getNumNinios() {
        return numNinios;
    }

    public void setNumNinios(String numNinios) {
        this.numNinios = numNinios;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public String getNumAdultos() {
        return numAdultos;
    }

    public void setNumAdultos(String numAdultos) {
        this.numAdultos = numAdultos;
    }

    public Reserva() {

    }
}
