package com.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Candidat implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String nomArabe;
	private String prenomArabe;
	private java.sql.Date dataNaissance;
	private String lieuNaissance;
	@Column(unique = true)
	private String cin;
	private String adresse;
	private String telephone;
	private String intituleBac;
	@Column(unique = true)
	private String cne;
	private int anneeBac;
	private String diplome;
	private String intituleFiliere;
	private String etablissement;
	private String ville;
	private double moyenne1;
	private double moyenne2;
	private double moyenneSortie;
	private int anneeDiplome;
	private boolean etat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCandidature")
	private Candidature candidature;
	
	public Candidat() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getNomArabe() {
		return nomArabe;
	}

	public void setNomArabe(String nomArabe) {
		this.nomArabe = nomArabe;
	}

	public String getPrenomArabe() {
		return prenomArabe;
	}

	public void setPrenomArabe(String prenomArabe) {
		this.prenomArabe = prenomArabe;
	}

	public java.sql.Date getDataNaissance() {
		return dataNaissance;
	}

	public void setDataNaissance(java.sql.Date dataNaissance) {
		this.dataNaissance = dataNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIntituleBac() {
		return intituleBac;
	}

	public void setIntituleBac(String intituleBac) {
		this.intituleBac = intituleBac;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public int getAnneeBac() {
		return anneeBac;
	}

	public void setAnneeBac(int anneeBac) {
		this.anneeBac = anneeBac;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getIntituleFiliere() {
		return intituleFiliere;
	}

	public void setIntituleFiliere(String intituleFiliere) {
		this.intituleFiliere = intituleFiliere;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public double getMoyenne1() {
		return moyenne1;
	}

	public void setMoyenne1(double moyenne1) {
		this.moyenne1 = moyenne1;
	}

	public double getMoyenne2() {
		return moyenne2;
	}

	public void setMoyenne2(double moyenne2) {
		this.moyenne2 = moyenne2;
	}

	public double getMoyenneSortie() {
		return moyenneSortie;
	}

	public void setMoyenneSortie(double moyenneSortie) {
		this.moyenneSortie = moyenneSortie;
	}

	public int getAnneeDiplome() {
		return anneeDiplome;
	}

	public void setAnneeDiplome(int anneeDiplome) {
		this.anneeDiplome = anneeDiplome;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Candidature getCandidature() {
		return candidature;
	}

	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}

	@Override
	public String toString() {
		return "Candidat [id=" + id + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", nomArabe=" + nomArabe + ", prenomArabe=" + prenomArabe + ", dataNaissance="
				+ dataNaissance + ", lieuNaissance=" + lieuNaissance + ", cin=" + cin + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", intituleBac=" + intituleBac + ", cne=" + cne + ", anneeBac="
				+ anneeBac + ", diplome=" + diplome + ", intituleFiliere=" + intituleFiliere + ", etablissement="
				+ etablissement + ", ville=" + ville + ", moyenne1=" + moyenne1 + ", moyenne2=" + moyenne2
				+ ", moyenneSortie=" + moyenneSortie + ", anneeDiplome=" + anneeDiplome + ", etat=" + etat
				+ ", candidature=" + candidature + "]";
	}

	
}
