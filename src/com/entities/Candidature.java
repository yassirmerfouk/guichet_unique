package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidature implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 1000)
	private String nom;
	private java.sql.Date dateOuverture;
	private java.sql.Date dateLimite;
	private java.sql.Date dateConcour;
	@Column(length = 5000)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "idFiliere")
	private Filiere filiere;
	
	@OneToMany(mappedBy = "candidature" , fetch = FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Candidat> candidats;

	public Candidature() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public java.sql.Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(java.sql.Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public java.sql.Date getDateLimite() {
		return dateLimite;
	}

	public void setDateLimite(java.sql.Date dateLimite) {
		this.dateLimite = dateLimite;
	}

	public java.sql.Date getDateConcour() {
		return dateConcour;
	}

	public void setDateConcour(java.sql.Date dateConcour) {
		this.dateConcour = dateConcour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public List<Candidat> getCandidats() {
		return candidats;
	}

	public void setCandidats(List<Candidat> candidats) {
		this.candidats = candidats;
	}

	@Override
	public String toString() {
		return "Candidature [id=" + id + ", nom=" + nom + ", dateOuverture=" + dateOuverture + ", dateLimite="
				+ dateLimite + ", dateConcour=" + dateConcour + ", description=" + description + ", filiere=" + filiere
				+ ", candidats=" + candidats + "]";
	}
	
	

	

	
	
	
}
