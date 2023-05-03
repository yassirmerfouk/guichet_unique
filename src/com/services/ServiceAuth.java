package com.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;
import com.dao.CandidatDAO;
import com.entities.Admin;
import com.entities.Candidat;

public class ServiceAuth {

	private AdminDAO adminDao;
	private CandidatDAO candidatDao;

	public ServiceAuth() {
		adminDao = new AdminDAO();
		candidatDao = new CandidatDAO();
	}

	public void doLoginAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("login");
		String password = request.getParameter("password");
		request.getSession().setAttribute("old_email", email);
		Admin admin = adminDao.findByEmailAndPassword(email, password);
		if (admin != null) {
			request.getSession().removeAttribute("old_email");
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect("../admin/accueil.asp");
		} else {
			request.getSession().setAttribute("error_login", "Verifiez votre email ou mot de passe");
			response.sendRedirect("../admin/connexion.asp");
		}
	}

	public void doLoginCandidat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("login");
		String password = request.getParameter("password");
		request.getSession().setAttribute("old_email", email);
		Candidat candidat = candidatDao.findByEmailAndPassword(email, password);
		if (candidat != null) {
			request.getSession().removeAttribute("old_email");
			request.getSession().setAttribute("candidat", candidat);
			response.sendRedirect("../candidat/candidat.asp");
		} else {
			request.getSession().setAttribute("error_login", "email ou password error");
			response.sendRedirect("../candidat/connexion.asp");
		}
	}

	public boolean isAdmin(HttpServletRequest request) {
		if (request.getSession().getAttribute("admin") != null)
			return true;
		return false;
	}

	public boolean isCandidat(HttpServletRequest request) {
		if (request.getSession().getAttribute("candidat") != null)
			return true;
		return false;
	}

	public boolean doRedirectToNotAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (!isAdmin(request)) {
			response.sendRedirect("../admin/connexion.asp");
			return true;
		}
		return false;
	}

	public boolean doRedirectToNotCandidatWithAccount(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (!isCandidat(request)) {
			response.sendRedirect("../candidat/connexion.asp");
			return true;
		}
		return false;
	}

	public boolean doRedirectToUserWithAccount(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (isAdmin(request) || isCandidat(request)) {
			if (isAdmin(request)) {
				response.sendRedirect("../admin/accueil.asp");
				return true;
			}
			if (isCandidat(request)) {
				response.sendRedirect("../candidat/candidat.asp");
				return true;
			}
		}
		return false;
	}

	public void doLogoutAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("../admin/connexion.asp");
	}

	public void doLogoutCandidat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("../candidat/connexion.asp");
	}

}
