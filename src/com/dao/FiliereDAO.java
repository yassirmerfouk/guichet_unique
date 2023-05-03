package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entities.Admin;
import com.entities.Filiere;

public class FiliereDAO {

	private EntityManager em;
	private EntityManagerFactory emf;

	public FiliereDAO() {
		emf = Persistence.createEntityManagerFactory("GichetLicence");
	}
	
	public void add(Filiere filiere) {
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(filiere);
		et.commit();
	}
	
	public List<Filiere> getAll(){
		em = emf.createEntityManager();
		Query query = em.createQuery("select f from Filiere f");
			return (List<Filiere>) query.getResultList();
	}
	
	public Filiere find(int id) {
		em = emf.createEntityManager();
		return em.find(Filiere.class, id);
	}
	
	public Filiere findByName(String nom) {
		em = emf.createEntityManager();
		Filiere filiere = null;
		Query query = em.createQuery("select f from Filiere f where f.nom = :nom ");
		query.setParameter("nom", nom);
		if(!query.getResultList().isEmpty())
			filiere = (Filiere) query.getResultList().get(0);
			return filiere;
	}
	
	public void update(Filiere filiere) {
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(filiere);
		et.commit();
	}
	
	public void delete(Filiere filiere) {
		em = emf.createEntityManager();
		filiere = em.find(Filiere.class, filiere.getId());
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(filiere);
		et.commit();
	}
	
}
