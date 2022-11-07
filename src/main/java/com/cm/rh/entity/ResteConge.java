package com.cm.rh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rh_resteConge")
public class ResteConge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private float droits;
	private float consome = 0;
	private float reste;

	@ManyToOne
	private TypeConge type;

	@ManyToOne
	private Personnel personnel;

	public ResteConge() {
		super();

	}

	public ResteConge(float droits, float consome, float reste, TypeConge type, Personnel personnel) {
		super();
		this.droits = droits;
		this.consome = consome;
		this.reste = reste;
		this.type = type;
		this.personnel = personnel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getDroits() {
		return droits;
	}

	public void setDroits(float droits) {
		this.droits = droits;
	}

	public float getConsome() {
		return consome;
	}

	public void setConsome(float consome) {
		this.consome = consome;
	}

	public float getReste() {
		return reste;
	}

	public void setReste(float reste) {
		this.reste = reste;
	}

	public TypeConge getType() {
		return type;
	}

	public void setType(TypeConge type) {
		this.type = type;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

}
