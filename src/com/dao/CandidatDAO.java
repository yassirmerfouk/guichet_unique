package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entities.Admin;
import com.entities.Candidat;
import com.entities.Candidature;

public class CandidatDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CandidatDAO() {
		emf = Persistence.createEntityManagerFactory("GichetLicence");
	}
	
	public Candidat findByEmailAndPassword(String email,String password) {
		em = emf.createEntityManager();
		Candidat candidat = null;
		Query query = em.createQuery("select c from Candidat c where c.email=:email and c.password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		if(!query.getResultList().isEmpty())
		candidat = (Candidat) query.getResultList().get(0);
		return candidat;
	}
	
	public void add(Candidat candidat) {
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(candidat);
		et.commit();
	}
	
	public void update(Candidat candidat) {
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(candidat);
		et.commit();
	}
	
	public Candidat find(int id) {
		em = emf.createEntityManager();
		return em.find(Candidat.class, id);
	}
	
	public Candidat findByEmail(String email) {
		em = emf.createEntityManager();
		Candidat candidat = null;
		Query query = em.createQuery("select c from Candidat c where c.email=:email");
		query.setParameter("email", email);
		if(!query.getResultList().isEmpty())
		candidat = (Candidat) query.getResultList().get(0);
		return candidat;
	}
	
	public Candidat findByCne(String cne) {
		em = emf.createEntityManager();
		Candidat candidat = null;
		Query query = em.createQuery("select c from Candidat c where c.cne=:cne");
		query.setParameter("cne", cne);
		if(!query.getResultList().isEmpty())
		candidat = (Candidat) query.getResultList().get(0);
		return candidat;
	}
	
	public Candidat findByCin(String cin) {
		em = emf.createEntityManager();
		Candidat candidat = null;
		Query query = em.createQuery("select c from Candidat c where c.cin=:cin");
		query.setParameter("cin", cin);
		if(!query.getResultList().isEmpty())
		candidat = (Candidat) query.getResultList().get(0);
		return candidat;
	}
	
	public List<Candidat> getAll(){
		em = emf.createEntityManager();
		Query query = em.createQuery("select c from Candidat c");
			return (List<Candidat>) query.getResultList();
	}
	
	public List<Candidat> getByCandidature(int id){
		em = emf.createEntityManager();
		Query query = em.createQuery("select c from Candidat c where c.candidature.id = :id");
		query.setParameter("id", id);
			return (List<Candidat>) query.getResultList();
	}
}
