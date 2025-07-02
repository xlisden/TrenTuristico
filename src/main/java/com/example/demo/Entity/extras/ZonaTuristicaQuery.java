package com.example.demo.Entity.extras;

public class ZonaTuristicaQuery {

    public int estacion;
    public int idZona;
    public String zona;
    public int tipoLugar;
    public int recorrido;
    public int llegada;
    public int hora;
    public double temperatura;
    public double intensidad;
    public int probabilidad;
    public int actividad;

    public ZonaTuristicaQuery() {
    }

    public ZonaTuristicaQuery(int estacion, int idZona, String zona, int tipoLugar, int recorrido, int llegada, int hora, double temperatura, double intensidad, int probabilidad, int actividad) {
        this.estacion = estacion;
        this.idZona = idZona;
        this.zona = zona;
        this.tipoLugar = tipoLugar;
        this.recorrido = recorrido;
        this.llegada = llegada;
        this.hora = hora;
        this.temperatura = temperatura;
        this.intensidad = intensidad;
        this.probabilidad = probabilidad;
        this.actividad = actividad;
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

    public int getTipoLugar() {
        return tipoLugar;
    }

    public void setTipoLugar(int tipoLugar) {
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

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    public double getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(double intensidad) {
        this.intensidad = intensidad;
    }

    public int getActividad() {
        return actividad;
    }

    public void setActividad(int actividad) {
        this.actividad = actividad;
    }

}