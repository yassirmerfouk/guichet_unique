package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Module implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@Column
	private String nom;
	@Column(length = 5000)
	private String Description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idFiliere")
	private Filiere filiere;
	
	public Module() {
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

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", nom=" + nom + ", Description=" + Description + ", filiere=" + filiere + "]";
	}

	
}
