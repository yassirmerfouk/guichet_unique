package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Filiere implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String nom;
	@Column(length = 5000)
	private String Description;
	@OneToMany(mappedBy = "filiere" , fetch = FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Module> modules;
	@OneToMany(mappedBy = "filiere" , fetch = FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Candidature> candidatures;
	
	public Filiere() {
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", nom=" + nom + ", Description=" + Description + ", modules=" + modules
				+ ", candidatures=" + candidatures + "]";
	}

	
	
}
