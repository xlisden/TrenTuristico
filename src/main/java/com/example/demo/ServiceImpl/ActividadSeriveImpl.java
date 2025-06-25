package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Actividad;
import com.example.demo.Repository.ActividadRepository;
import com.example.demo.Service.ActividadService;

@Service("actiservice")
public class ActividadSeriveImpl implements ActividadService{
	
	@Autowired
	@Qualifier("actirepository")
	private ActividadRepository actirepo;

	@Override
	public List<Actividad> findAllActi() {
		return actirepo.findAll();
	}

	@Override
	public Actividad addActi(Actividad acti) {
		return actirepo.save(acti);
	}

	@Override
	public Actividad getActi(int id) throws Exception {
		return actirepo.findById(id).orElseThrow(() -> new Exception("La actividad no existe."));
	}

	@Override
	public void deleteActi(int id) {
		actirepo.deleteById(id);
	}
	
}
