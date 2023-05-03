package com.services;

import java.io.IOException;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.Config;
import com.dao.FiliereDAO;
import com.entities.Filiere;

public class ServiceFiliere {
	
	private FiliereDAO filiereDao;
	
	public ServiceFiliere() {
		filiereDao = new FiliereDAO();
	}

	public void index(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("filieres", filiereDao.getAll());
	}
	
	public void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		request.getSession().setAttribute("old_nom", request.getParameter("nom"));
		request.getSession().setAttribute("old_description", request.getParameter("description"));
		if(request.getParameter("nom").isEmpty()) {
			request.getSession().setAttribute("error_nom","champ obligatoire *");
			response.sendRedirect("../admin/ajouterfiliere.asp");
		}else {
			if(filiereDao.findByName(request.getParameter("nom")) != null) {
				request.getSession().setAttribute("error_nom","vous devez utilisé un autre nom");
				response.sendRedirect("../admin/ajouterfiliere.asp");
			}else {
				Filiere filiere = new Filiere();
				filiere.setNom(request.getParameter("nom").trim());
				filiere.setDescription(request.getParameter("description").trim());
				filiereDao.add(filiere);
				request.getSession().removeAttribute("old_nom");
				request.getSession().removeAttribute("old_description");
				request.getSession().setAttribute("add_success", "La filiere est ajouté avec succèss");
				response.sendRedirect("../admin/filieres.asp");
			}
		}
	}
	
	public void show(HttpServletRequest request,HttpServletResponse response) {
		Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
		if(filiere != null) {
			request.setAttribute("filiere",filiere);
		}
	}
	
	public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
		if(filiere != null) {
			request.setAttribute("filiere",filiere );
		}
	}
	
	public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("nom").isEmpty()) {
			request.getSession().setAttribute("error_nom","champ obligatoire");
			response.sendRedirect("../admin/modifierfiliere.asp?idfiliere="+request.getParameter("idfiliere"));
		}
		else {
			Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
			if(filiere != null) {
				filiere.setNom(request.getParameter("nom").trim());
				filiere.setDescription(request.getParameter("description").trim());
				try {
					filiereDao.update(filiere);
					request.getSession().setAttribute("update_success", "La filiere est modifié avec succèss");
					response.sendRedirect("../admin/filieres.asp");
				}catch(PersistenceException e) {
					e.printStackTrace();
					request.getSession().setAttribute("error_nom","vouz devez utilisé un autre nom");
					response.sendRedirect("../admin/modifierfiliere.asp?idfiliere="+request.getParameter("idfiliere"));
				}}
		}
	}
	
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
		if(filiere != null) {
			filiereDao.delete(filiere);
			response.sendRedirect("../admin/filieres.asp");
			request.getSession().setAttribute("delete_success", "La filiere est supprimé avec succèss");
		}
	}
}
