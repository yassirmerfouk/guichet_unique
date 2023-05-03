package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entities.Admin;

public class AdminDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AdminDAO() {
		emf = Persistence.createEntityManagerFactory("GichetLicence");
	}
	
	public Admin findByEmailAndPassword(String email,String password) {
		em = emf.createEntityManager();
		Admin admin = null;
		Query query = em.createQuery("select a from Admin a where a.email=:email and a.password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		if(!query.getResultList().isEmpty())
		admin = (Admin) query.getResultList().get(0);
		return admin;
	}
}
