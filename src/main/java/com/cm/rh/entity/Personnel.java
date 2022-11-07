package com.cm.rh.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "rh_personnel")
public class Personnel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(unique = true)
	private String matricule;

	private String nom;
	private String prenom;
	private String telephonefix;
	private String email;
	@Column(nullable = true)
	private long grade;
	@Column(nullable = true)
	private long echelle;
	@Column(nullable = true)
	private long echlon;

	private String cin;
	@Column(nullable = true)
	private long idDivision;
	@Column(nullable = true)
	private long idService;
	private String telephoneGsm;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateEmbauche;
	@Column(nullable = true)
	private int nbEnfantsM;
	@Column(nullable = true)
	private int nbEnfantsF;

	@ManyToOne(fetch = FetchType.LAZY)
	private NiveauAcademique niveauAcademique;

	@ManyToOne(fetch = FetchType.LAZY)
	private Sex sex;

	@ManyToOne(fetch = FetchType.LAZY)
	private SituationFamiliale situationFamiliale;

	@ManyToOne(fetch = FetchType.LAZY)
	private TypePersonnel typePersonnel;

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JsonIgnoreProperties("personnels")
	@JoinTable(name = "rh_personnel_type_conge", joinColumns = {
			@JoinColumn(name = "personnel_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "type_id", referencedColumnName = "id") })
	Set<TypeConge> typesConges = new HashSet<TypeConge>();

	public Personnel() {
		super();

	}

	public Personnel(long id, String nom, String prenom, @NotNull String matricule) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;

	}

	public Personnel(long id, @NotNull String matricule, String nom, String prenom, TypePersonnel typePersonnel) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.typePersonnel = typePersonnel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephonefix() {
		return telephonefix;
	}

	public void setTelephonefix(String telephonefix) {
		this.telephonefix = telephonefix;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getGrade() {
		return grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

	public long getEchelle() {
		return echelle;
	}

	public void setEchelle(long echelle) {
		this.echelle = echelle;
	}

	public long getEchlon() {
		return echlon;
	}

	public void setEchlon(long echlon) {
		this.echlon = echlon;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public long getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(long idDivision) {
		this.idDivision = idDivision;
	}

	public long getIdService() {
		return idService;
	}

	public void setIdService(long idService) {
		this.idService = idService;
	}

	public String getTelephoneGsm() {
		return telephoneGsm;
	}

	public void setTelephoneGsm(String telephoneGsm) {
		this.telephoneGsm = telephoneGsm;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public int getNbEnfantsM() {
		return nbEnfantsM;
	}

	public void setNbEnfantsM(int nbEnfantsM) {
		this.nbEnfantsM = nbEnfantsM;
	}

	public int getNbEnfantsF() {
		return nbEnfantsF;
	}

	public void setNbEnfantsF(int nbEnfantsF) {
		this.nbEnfantsF = nbEnfantsF;
	}

	public NiveauAcademique getNiveauAcademique() {
		return niveauAcademique;
	}

	public void setNiveauAcademique(NiveauAcademique niveauAcademique) {
		this.niveauAcademique = niveauAcademique;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public SituationFamiliale getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(SituationFamiliale situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public TypePersonnel getTypePersonnel() {
		return typePersonnel;
	}

	public void setTypePersonnel(TypePersonnel typePersonnel) {
		this.typePersonnel = typePersonnel;
	}

	public Set<TypeConge> getTypesConges() {
		return typesConges;
	}

	public void setTypesConges(Set<TypeConge> typesConges) {
		this.typesConges = typesConges;
	}

}