package com.services;

import java.io.IOException;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FiliereDAO;
import com.dao.ModuleDAO;
import com.entities.Filiere;
import com.entities.Module;
import com.mysql.fabric.Response;

public class ServiceModule {
	
	private FiliereDAO filiereDao;
	private ModuleDAO moduleDao;
	
	public ServiceModule() {
		filiereDao = new FiliereDAO();
		moduleDao = new ModuleDAO(); 
	}

	public void index(HttpServletRequest request,HttpServletResponse response) {
		Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
		if(filiere != null) {
			request.setAttribute("modules", filiere.getModules());
		}
	}
	
	public void store(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		request.getSession().setAttribute("old_nom", request.getParameter("nom"));
		request.getSession().setAttribute("old_description", request.getParameter("description"));
		if(request.getParameter("nom").isEmpty() || request.getParameter("idfiliere") == null) {
			if(request.getParameter("nom").isEmpty())
			request.getSession().setAttribute("error_nom", "champ obligatoire");
			if(request.getParameter("idfiliere") == null)
				request.getSession().setAttribute("error_filiere", "champ obligatoire");
			response.sendRedirect("../admin/ajoutermodule.asp");
		}else {
			Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
			if(filiere != null) {
				Module module = new Module();
				module.setNom(request.getParameter("nom").trim());
				module.setDescription(request.getParameter("description").trim());
				module.setFiliere(filiere);
				moduleDao.add(module);
				request.getSession().removeAttribute("old_nom");
				request.getSession().removeAttribute("old_description");
				request.getSession().setAttribute("add_success", "Le module est ajouté avec success");
				response.sendRedirect("../admin/modules.asp?idfiliere="+ filiere.getId());
			}
		}
    }
	
	public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Module module = moduleDao.find(Integer.parseInt(request.getParameter("idmodule")));
		if(module != null) {
			request.setAttribute("module", module);
		}
	}
	
	public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("nom").isEmpty() || request.getParameter("idfiliere") == null) {
			if(request.getParameter("nom").isEmpty())
				request.getSession().setAttribute("error_nom", "champ obligatoire");
			if(request.getParameter("idfiliere") == null)
				request.getSession().setAttribute("error_filiere", "champ obligatoire");
			response.sendRedirect("../admin/modifiermodule.asp?idmodule="+request.getParameter("idmodule"));
		}
		else {
			Module module = moduleDao.find(Integer.parseInt(request.getParameter("idmodule")));
			Filiere filiere = filiereDao.find(Integer.parseInt(request.getParameter("idfiliere")));
			if(module != null && filiere != null) {
				module.setNom(request.getParameter("nom").trim());
				module.setDescription(request.getParameter("description").trim());
				module.setFiliere(filiere);
				moduleDao.update(module);
				request.getSession().setAttribute("update_success", "Le module est modifié avec succèss");
				response.sendRedirect("../admin/modules.asp?idfiliere="+module.getFiliere().getId());
			}
		}
	}
	
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Module module = moduleDao.find(Integer.parseInt(request.getParameter("idmodule")));
		if(module != null) {
			moduleDao.delete(module);
			request.getSession().setAttribute("delete_success", "Le module est supprimé avec succèss");
			response.sendRedirect("../admin/modules.asp?idfiliere="+module.getFiliere().getId());
		}
	}
}
