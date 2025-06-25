package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Actividad;

public interface ActividadService {
	public abstract List<Actividad> findAllActi();
	public abstract Actividad addActi(Actividad acti);
	public abstract Actividad getActi(int id)throws Exception;
	public abstract void deleteActi(int id);
	
}
