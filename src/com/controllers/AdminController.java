package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.Config;
import com.dao.FiliereDAO;
import com.library.Controller;
import com.library.GeneratedPdf;
import com.services.ServiceAuth;
import com.services.ServiceCandidat;
import com.services.ServiceCandidature;
import com.services.ServiceFiliere;
import com.services.ServiceModule;

public class AdminController extends Controller {

	private ServiceFiliere serviceFiliere;
	private ServiceAuth serviceAuth;
	private ServiceModule serviceModule;
	private ServiceCandidature serviceCandidature;
	private ServiceCandidat serviceCandidat;
	private GeneratedPdf generatedPdf;

	public AdminController(HttpServletRequest request) {
		serviceAuth = (ServiceAuth) request.getServletContext().getAttribute("serviceAuth");
		serviceFiliere = (ServiceFiliere) request.getServletContext().getAttribute("serviceFiliere");
		serviceModule = (ServiceModule) request.getServletContext().getAttribute("serviceModule");
		serviceCandidature = (ServiceCandidature) request.getServletContext().getAttribute("serviceCandidature");
		serviceCandidat = (ServiceCandidat) request.getServletContext().getAttribute("serviceCandidat");
		generatedPdf = (GeneratedPdf) request.getServletContext().getAttribute("generatedPdf");
	}

	public void connexion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToUserWithAccount(request, response))
			return;
		if (request.getMethod().equals("GET")) {
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/connexion.jsp").forward(request, response);
		} else
			serviceAuth.doLoginAdmin(request, response);
	}

	public void deconnexion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		serviceAuth.doLogoutAdmin(request, response);
	}

	public void accueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		serviceFiliere.index(request, response);
		serviceCandidature.index(request, response);
		request.getRequestDispatcher(Config.VIEWS_PATH + "admin/accueil.jsp").forward(request, response);
	}

	public void filieres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		serviceFiliere.index(request, response);
		request.getRequestDispatcher(Config.VIEWS_PATH + "admin/filieres/filieres.jsp").forward(request, response);
	}

	public void filiere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
	}

	public void ajouterfiliere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET")) {
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/filieres/ajouterfiliere.jsp").forward(request, response);
		} else
			serviceFiliere.store(request, response);
	}

	public void modifierfiliere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET") && request.getParameter("idfiliere") != null) {
			serviceFiliere.edit(request, response);
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/filieres/modifierfiliere.jsp").forward(request, response);
		} else {
			if (request.getMethod().equals("POST"))
				serviceFiliere.update(request, response);
			else
				response.sendRedirect("../admin/filieres.asp");
		}
	}

	public void supprimerfiliere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("POST")) {
			serviceFiliere.delete(request, response);
		} else
			response.sendRedirect("../admin/filieres.asp");
	}

	public void modules(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET") && request.getParameter("idfiliere") != null) {
			serviceModule.index(request, response);
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/modules/modules.jsp").forward(request, response);
		} else {
			response.sendRedirect("../admin/filieres.asp");
		}
	}

	public void ajoutermodule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET")) {
			serviceFiliere.index(request, response);
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/modules/ajoutermodule.jsp").forward(request, response);
		} else {
			serviceModule.store(request, response);
		}
	}

	public void modifiermodule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET") && request.getParameter("idmodule") != null) {
			serviceModule.edit(request, response);
			serviceFiliere.index(request, response);
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/modules/modifiermodule.jsp").forward(request, response);
		} else {
			if (request.getMethod().equals("POST"))
				serviceModule.update(request, response);
			else
				response.sendRedirect("../admin/filieres.asp");
		}
	}

	public void supprimermodule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("POST") && request.getParameter("idmodule") != null) {
			serviceModule.delete(request, response);
		} else {
			response.sendRedirect("../admin/filieres.asp");
		}
	}

	public void candidatures(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceCandidature.index(request, response);
		request.getRequestDispatcher(Config.VIEWS_PATH + "admin/candidatures/candidatures.jsp").forward(request, response);
	}

	public void ajoutercandidature(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET")) {
			serviceFiliere.index(request, response);
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/candidatures/ajoutercandidature.jsp").forward(request, response);
		} else {
			serviceCandidature.store(request, response);
		}
	}

	public void modifiercandidature(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET") && request.getParameter("idcandidature") != null) {
			serviceFiliere.index(request, response);
			serviceCandidature.edit(request, response);
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/candidatures/modifiercandidature.jsp").forward(request, response);
		} else {
			if (request.getMethod().equals("POST"))
				serviceCandidature.update(request, response);
			else
				response.sendRedirect("../admin/candidatures.asp");
		}
	}

	public void supprimercandidature(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("POST") && request.getParameter("idcandidature") != null) {
			serviceCandidature.delete(request, response);
		} else {
			response.sendRedirect("../admin/candidatures.asp");
		}
	}

	public void candidats(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET") || request.getMethod().equals("POST")) {
			serviceCandidature.index(request, response);
			serviceCandidat.index(request, response);
			request.getRequestDispatcher(Config.VIEWS_PATH + "admin/candidats/candidats.jsp").forward(request, response);
		}
	}

	public void pdfcandidat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (serviceAuth.doRedirectToNotAdmin(request, response))
			return;
		if (request.getMethod().equals("GET")) {
			generatedPdf.generatePdf(request, response);
		}
	}
}
