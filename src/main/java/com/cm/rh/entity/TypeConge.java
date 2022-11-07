package com.cm.rh.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "rh_typeConge")
public class TypeConge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	private float droits;
	private boolean droitsCalcule;

	@ManyToMany(mappedBy = "typesConges", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnoreProperties("typesConges")
	private Set<Personnel> personnels = new HashSet<Personnel>();

	public TypeConge() {
		super();

	}

	public TypeConge(String libelle, float droits, boolean droitsCalcule) {
		super();
		this.libelle = libelle;
		this.droits = droits;
		this.droitsCalcule = droitsCalcule;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getDroits() {
		return droits;
	}

	public void setDroits(float droits) {
		this.droits = droits;
	}

	public boolean isDroitsCalcule() {
		return droitsCalcule;
	}

	public void setDroitsCalcule(boolean droitsCalcule) {
		this.droitsCalcule = droitsCalcule;
	}

}
