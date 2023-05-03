package com.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.Config;
import com.library.Controller;
import com.library.GeneratedPdf;
import com.services.ServiceAuth;
import com.services.ServiceCandidat;
import com.services.ServiceCandidature;
import com.services.ServiceFiliere;

public class CandidatController extends Controller{

	private ServiceAuth serviceAuth;
	private ServiceFiliere serviceFiliere;
	private ServiceCandidature serviceCandidature;
	private ServiceCandidat serviceCandidat;
	private GeneratedPdf generatedPdf;
	
	public CandidatController(HttpServletRequest request) {
		serviceAuth = (ServiceAuth) request.getServletContext().getAttribute("serviceAuth");
		serviceFiliere = (ServiceFiliere) request.getServletContext().getAttribute("serviceFiliere");
		serviceCandidature = (ServiceCandidature) request.getServletContext().getAttribute("serviceCandidature");
		serviceCandidat = (ServiceCandidat) request.getServletContext().getAttribute("serviceCandidat");
		generatedPdf = (GeneratedPdf) request.getServletContext().getAttribute("generatedPdf");
	}
	
	public void connexion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(serviceAuth.doRedirectToUserWithAccount(request, response))
			return;
		if(request.getMethod().equals("GET") )
			request.getRequestDispatcher(Config.VIEWS_PATH + "candidat/connexion.jsp").forward(request, response);
		else
			serviceAuth.doLoginCandidat(request, response);
		
	}
	
	public void deconnexion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotCandidatWithAccount(request, response))
			return;
		serviceAuth.doLogoutCandidat(request, response);
	}

	
	public void accueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(serviceAuth.doRedirectToUserWithAccount(request, response))
			return;
		serviceFiliere.index(request, response);
		serviceCandidature.index(request, response);
		request.getRequestDispatcher(Config.VIEWS_PATH + "accueil.jsp").forward(request, response);
	}
	
	public void candidatures(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(serviceAuth.doRedirectToUserWithAccount(request, response))
			return;
		serviceCandidature.index(request, response);
		request.getRequestDispatcher(Config.VIEWS_PATH + "candidat/candidatures.jsp").forward(request, response);
	}
	
	public void inscription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(serviceAuth.doRedirectToUserWithAccount(request, response))
			return;
		if(request.getMethod().equals("GET") && request.getParameter("idcandidature") != null ) {
			serviceCandidature.show(request, response);
			request.getRequestDispatcher(Config.VIEWS_PATH + "candidat/inscription.jsp").forward(request, response);
		}else {
			if(request.getMethod().equals("POST"))
				serviceCandidat.store(request, response);
			else
				response.sendRedirect("../candidat/candidatures.asp");
		}
	}
	
	public void candidat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotCandidatWithAccount(request, response))
			return;
		if(request.getMethod().equals("GET")) {
			request.getRequestDispatcher(Config.VIEWS_PATH + "candidat/candidat.jsp").forward(request, response);
		}else
			response.sendRedirect("../candidat/candidat.asp");
	}
	
	public void modifierinscription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotCandidatWithAccount(request, response))
			return;
		if(request.getMethod().equals("POST")) {
			serviceCandidat.update(request, response);
		}else
			response.sendRedirect("../candidat/candidat.asp");
	}
	
	public void pdfcandidat(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotCandidatWithAccount(request, response))
			return;
		if (request.getMethod().equals("GET")) {
			generatedPdf.generatePdf(request, response);
		}
	}
}
