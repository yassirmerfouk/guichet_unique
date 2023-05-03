package com.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.entities.Module;;

public class ModuleDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public ModuleDAO() {
		emf = Persistence.createEntityManagerFactory("GichetLicence");
	}
	
	public void add(Module module) {
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(module);
		et.commit();
	}
	
	public List<Module> getAll(){
		em = emf.createEntityManager();
		Query query = em.createQuery("select m from Module m");
			return (List<Module>) query.getResultList();
	}
	
	public Module find(int id) {
		em = emf.createEntityManager();
		return em.find(Module.class, id);
	}
	
	public Module findByName(String nom) {
		em = emf.createEntityManager();
		Module module = null;
		Query query = em.createQuery("select m from Module m where m.nom = :nom ");
		query.setParameter("nom", nom);
		if(!query.getResultList().isEmpty())
			module = (Module) query.getResultList().get(0);
			return module;
	}
	
	public void update(Module module) {
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(module);
		et.commit();
	}
	
	public void delete(Module module) {
		em = emf.createEntityManager();
		module = em.find(Module.class, module.getId());
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(module);
		et.commit();
	}
	
}
