package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ActId")
	private int ActId;
	
	@Column(name = "ActNom", length = 30)
	private String actNom;

	public Actividad() {
		super();
	}

	public Actividad(int actId, String actNom) {
		super();
		this.ActId = actId;
		this.actNom = actNom;
	}

	public int getActId() {
		return ActId;
	}

	public void setActId(int actId) {
		ActId = actId;
	}

	public String getActNom() {
		return actNom;
	}

	public void setActNom(String actNom) {
		this.actNom = actNom;
	}

}
