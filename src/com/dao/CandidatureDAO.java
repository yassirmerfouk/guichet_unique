package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entities.Candidature;
import com.entities.Filiere;

public class CandidatureDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public CandidatureDAO() {
		emf = Persistence.createEntityManagerFactory("GichetLicence");
	}
	
	public void add(Candidature candidature) {
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(candidature);
		et.commit();
	}
	
	public List<Candidature> getAll(){
		em = emf.createEntityManager();
		Query query = em.createQuery("select c from Candidature c");
			return (List<Candidature>) query.getResultList();
	}
	
	public Candidature find(int id) {
		em = emf.createEntityManager();
		return em.find(Candidature.class, id);
	}
	
	public void update(Candidature candidature) {
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(candidature);
		et.commit();
	}
	
	public void delete(Candidature candidature) {
		em = emf.createEntityManager();
		candidature = em.find(Candidature.class, candidature.getId());
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(candidature);
		et.commit();
	}
}
