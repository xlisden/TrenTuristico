package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Actividad;

public interface ActividadService {
	public abstract List<Actividad> listar();
	public abstract Actividad addActi(Actividad acti);
	public abstract Actividad updateActi(Actividad actividad);
	public abstract Actividad getActi(int id)throws Exception;
	public abstract void deleteActi(int id);
	
}
