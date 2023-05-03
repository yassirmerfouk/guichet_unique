package com.services;

import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CandidatureDAO;
import com.dao.FiliereDAO;
import com.entities.Candidature;
import com.entities.Filiere;
import com.entities.Module;

public class ServiceCandidature {
	
	private CandidatureDAO candidatureDao;
	private FiliereDAO filiereDao;
	
	public ServiceCandidature() {
		candidatureDao = new CandidatureDAO();
		filiereDao = new FiliereDAO();
	}
	
	public void index(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("candidatures", candidatureDao.getAll());
	}

	public void store(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		request.getSession().setAttribute("old_nom", request.getParameter("nom"));
		request.getSession().setAttribute("old_description", request.getParameter("description"));
		request.getSession().setAttribute("old_dateOuverture", request.getParameter("dateOuverture"));
		request.getSession().setAttribute("old_dateLimite", request.getParameter("dateLimite"));
		request.getSession().setAttribute("old_dateConcour", request.getParameter("dateConcour"));
		if(request.getParameter("nom").isEmpty() || request.getParameter("idfiliere") == null || request.getParameter("dateOuverture").isEmpty() || request.getParameter("dateLimite").isEmpty() || request.getParameter("dateConcour").isEmpty()) {
			if(request.getParameter("nom").isEmpty())
			request.getSession().setAttribute("error_nom", "champ obligatoire");
			if(request.getParameter("idfiliere") == null)
				request.getSession().setAttribute("error_filiere", "champ obligatoire");
			if(request.getParameter("dateOuverture").isEmpty())
				request.getSession().setAttribute("error_dateOuverture", "champ obligatoire");
			if(request.getParameter("dateLimite").isEmpty())
				request.getSession().setAttribute("error_dateLimite", "champ obligatoire");
			if(request.getParameter("dateConcour").isEmpty())
				request.getSession().setAttribute("error_dateConcour", "champ obligatoire");
			response.sendRedirect("../admin/ajoutercandidature.asp");
		}else {
			SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");   
		    Date curentDate = new Date();  
		    Date date1 = null; Date date2 = null; Date date3 = null;
			try {
				date1 = formatter.parse(request.getParameter("dateOuverture"));
				date2 = formatter.parse(request.getParameter("dateLimite"));
				date3 = formatter.parse(request.getParameter("dateConcour"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(curentDate.compareTo(date1) > 0 || curentDate.compareTo(date2) > 0 || curentDate.compareTo(date3) > 0) {
				if(curentDate.compareTo(date1) > 0)
					request.getSession().setAttribute("error_dateOuverture", "vouz devez donner une date > date d'aujourd'hui");
				if(curentDate.compareTo(date2) > 0)
					request.getSession().setAttribute("error_dateLimite", "vouz devez donner une date > date d'aujourd'hui");
				if(curentDate.compareTo(date3) > 0)
					request.getSession().setAttribute("error_dateConcour", "vouz devez donner une date > date d'aujourd'hui");
				response.sendRedirect("../admin/ajoutercandidature.asp");
			}else {
				if(date1.compareTo(date2) > 0 || date1.compareTo(date2) > 0) {
					if(date1.compareTo(date2) > 0)
						request.getSession().setAttribute("error_dateLimite", "vouz devez donner une date limité > date d'ouverture");
					if(date1.compareTo(date3) > 0)
						request.getSession().setAttribute("error_dateConcour", "vouz devez donner une date concour > date d'ouverture");
					response.sendRedirect("../admin/ajoutercandidature.asp");
				}else {
					if(date2.compareTo(date3) > 0) {
						request.getSession().setAttribute("error_dateConcour", "vouz devez donner une date concour > date limité");
						response.sendRedirect("../admin/ajoutercandidature.asp");
					}else {
						Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
						if(filiere != null) {
							Candidature candidature = new Candidature();
							candidature.setNom(request.getParameter("nom"));
							candidature.setDateOuverture(new java.sql.Date(date1.getTime()));
							candidature.setDateLimite(new java.sql.Date(date2.getTime()));
							candidature.setDateConcour(new java.sql.Date(date3.getTime()));
							candidature.setDescription(request.getParameter("description"));
							candidature.setFiliere(filiere);
							candidatureDao.add(candidature);
							request.getSession().removeAttribute("old_nom");
							request.getSession().removeAttribute("old_description");
							request.getSession().removeAttribute("old_dateOuverture");
							request.getSession().removeAttribute("old_dateLimite");
							request.getSession().removeAttribute("old_dateConcour");
							request.getSession().setAttribute("add_success", "la candidature est ajoutée avec success");
							response.sendRedirect("../admin/candidatures.asp");
						}
					}
				}
			}
		}
    }
	
	public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Candidature candidature = candidatureDao.find(Integer.parseInt(request.getParameter("idcandidature")));
		if(candidature != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			request.setAttribute("candidature", candidature);
		}
	}
	
	public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("nom").isEmpty() || request.getParameter("idfiliere") == null || request.getParameter("dateOuverture").isEmpty() || request.getParameter("dateLimite").isEmpty() || request.getParameter("dateConcour").isEmpty()) {
			if(request.getParameter("nom").isEmpty())
			request.getSession().setAttribute("error_nom", "champ obligatoire");
			if(request.getParameter("idfiliere") == null)
				request.getSession().setAttribute("error_filiere", "champ obligatoire");
			if(request.getParameter("dateOuverture").isEmpty())
				request.getSession().setAttribute("error_dateOuverture", "champ obligatoire");
			if(request.getParameter("dateLimite").isEmpty())
				request.getSession().setAttribute("error_dateLimite", "champ obligatoire");
			if(request.getParameter("dateConcour").isEmpty())
				request.getSession().setAttribute("error_dateConcour", "champ obligatoire");
			response.sendRedirect("../admin/modifiercandidature.asp?idcandidature="+request.getParameter("idcandidature"));
		}else {
			SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");   
		    Date curentDate = new Date();  
		    Date date1 = null; Date date2 = null; Date date3 = null;
			try {
				date1 = formatter.parse(request.getParameter("dateOuverture"));
				date2 = formatter.parse(request.getParameter("dateLimite"));
				date3 = formatter.parse(request.getParameter("dateConcour"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(curentDate.compareTo(date2) > 0 || curentDate.compareTo(date3) > 0) {
				if(curentDate.compareTo(date2) > 0)
					request.getSession().setAttribute("error_dateLimite", "vouz devez donner une date > date d'aujourd'hui");
				if(curentDate.compareTo(date3) > 0)
					request.getSession().setAttribute("error_dateConcour", "vouz devez donner une date > date d'aujourd'hui");
				response.sendRedirect("../admin/modifiercandidature.asp?idcandidature="+request.getParameter("idcandidature"));
			}else {
				if(date1.compareTo(date2) > 0 || date1.compareTo(date2) > 0) {
					if(date1.compareTo(date2) > 0)
						request.getSession().setAttribute("error_dateLimite", "vouz devez donner une date limité > date d'ouverture");
					if(date1.compareTo(date3) > 0)
						request.getSession().setAttribute("error_dateConcour", "vouz devez donner une date concour > date d'ouverture");
					response.sendRedirect("../admin/modifiercandidature.asp?idcandidature="+request.getParameter("idcandidature"));
				}else {
					if(date2.compareTo(date3) > 0) {
						request.getSession().setAttribute("error_dateConcour", "vouz devez donner une date concour > date limité");
						response.sendRedirect("../admin/modifiercandidature.asp?idcandidature="+request.getParameter("idcandidature"));
					}else {
						Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
						Candidature candidature = candidatureDao.find(Integer.parseInt(request.getParameter("idcandidature")));
						if(candidature != null && filiere != null) {
							candidature.setNom(request.getParameter("nom"));
							candidature.setDateOuverture(new java.sql.Date(date1.getTime()));
							candidature.setDateLimite(new java.sql.Date(date2.getTime()));
							candidature.setDateConcour(new java.sql.Date(date3.getTime()));
							candidature.setDescription(request.getParameter("description"));
							candidature.setFiliere(filiere);
							candidatureDao.update(candidature);
							request.getSession().setAttribute("update_success", "la candidature est modifiée avec success");
							response.sendRedirect("../admin/candidatures.asp");
						}
					}
				}
			}
		}
    }
	
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Candidature candidature = candidatureDao.find(Integer.parseInt(request.getParameter("idcandidature")));
		if(candidature != null) {
			candidatureDao.delete(candidature);
			request.getSession().setAttribute("delete_success", "La candidature est supprimé avec succèss");
			response.sendRedirect("../admin/candidatures.asp");
		}
	}
	
	public void show(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Candidature candidature = candidatureDao.find(Integer.parseInt(request.getParameter("idcandidature")));
		if(candidature != null) {
			request.setAttribute("candidature", candidature);
		}
	}
}
