package com.cm.rh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rh_sexe")
public class Sex {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private char code;
	private String libelle;
	public Sex() {
		super();
			}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getCode() {
		return code;
	}
	public void setCode(char code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
