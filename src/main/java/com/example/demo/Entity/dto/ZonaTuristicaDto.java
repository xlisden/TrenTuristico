package com.example.demo.Entity.dto;

public class ZonaTuristicaDto {

    public int estacion;
    public int idZona;
    public String zona;
    public String tipoLugar;
    public int recorrido;
    public int llegada;
    public int temperatura;
    public int actividad;
    public String url;

    public ZonaTuristicaDto() {
    }

    public int getEstacion() {
        return estacion;
    }

    public void setEstacion(int estacion) {
        this.estacion = estacion;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipoLugar() {
        return tipoLugar;
    }

    public void setTipoLugar(String tipoLugar) {
        this.tipoLugar = tipoLugar;
    }

    public int getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(int recorrido) {
        this.recorrido = recorrido;
    }

    public int getLlegada() {
        return llegada;
    }

    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getActividad() {
        return actividad;
    }

    public void setActividad(int actividad) {
        this.actividad = actividad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}