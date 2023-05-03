package com.services;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CandidatDAO;
import com.dao.CandidatureDAO;
import com.entities.Candidat;
import com.entities.Candidature;
import com.entities.Filiere;
import com.library.Mailer;

public class ServiceCandidat {

	private CandidatDAO candidatDao;
	private CandidatureDAO candidatureDao;

	public ServiceCandidat() {
		candidatDao = new CandidatDAO();
		candidatureDao = new CandidatureDAO();
	}

	public void index(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("idCandidature") == null)
			request.setAttribute("candidats", candidatDao.getAll());
		else
			request.setAttribute("candidats",
					candidatDao.getByCandidature(Integer.parseInt(request.getParameter("idCandidature"))));
	}

	public void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		request.getSession().setAttribute("old_nom", request.getParameter("nom"));
		request.getSession().setAttribute("old_prenom", request.getParameter("prenom"));
		request.getSession().setAttribute("old_nomArabe", request.getParameter("nomArabe"));
		request.getSession().setAttribute("old_prenomArabe", request.getParameter("prenomArabe"));
		request.getSession().setAttribute("old_email", request.getParameter("email"));
		request.getSession().setAttribute("old_cin", request.getParameter("cin"));
		request.getSession().setAttribute("old_dateNaissance", request.getParameter("dateNaissance"));
		request.getSession().setAttribute("old_lieuNaissance", request.getParameter("lieuNaissance"));
		request.getSession().setAttribute("old_adresse", request.getParameter("adresse"));
		request.getSession().setAttribute("old_telephone", request.getParameter("telephone"));
		request.getSession().setAttribute("old_cne", request.getParameter("cne"));
		request.getSession().setAttribute("old_intituleBac", request.getParameter("intituleBac"));
		request.getSession().setAttribute("old_anneeBac", request.getParameter("anneeBac"));
		request.getSession().setAttribute("old_diplome", request.getParameter("diplome"));
		request.getSession().setAttribute("old_intituleFiliere", request.getParameter("intituleFiliere"));
		request.getSession().setAttribute("old_etablissement", request.getParameter("etablissement"));
		request.getSession().setAttribute("old_ville", request.getParameter("ville"));
		request.getSession().setAttribute("old_moyenne1", request.getParameter("moyenne1"));
		request.getSession().setAttribute("old_moyenne2", request.getParameter("moyenne2"));
		request.getSession().setAttribute("old_moyenneSortie", request.getParameter("moyenneSortie"));
		request.getSession().setAttribute("old_anneeDiplome", request.getParameter("anneeDiplome"));

		if (request.getParameter("nom").isEmpty() || request.getParameter("prenom").isEmpty()
				|| request.getParameter("nomArabe").isEmpty() || request.getParameter("prenomArabe").isEmpty()
				|| request.getParameter("email").isEmpty() || request.getParameter("cin").isEmpty()
				|| request.getParameter("dateNaissance").isEmpty() || request.getParameter("lieuNaissance").isEmpty()
				|| request.getParameter("adresse").isEmpty() || request.getParameter("telephone").isEmpty()
				|| request.getParameter("cne").isEmpty() || request.getParameter("intituleBac").isEmpty()
				|| request.getParameter("anneeBac").isEmpty() || request.getParameter("diplome").isEmpty()
				|| request.getParameter("intituleFiliere").isEmpty() || request.getParameter("etablissement").isEmpty()
				|| request.getParameter("ville").isEmpty() || request.getParameter("moyenne1").isEmpty()
				|| request.getParameter("moyenne2").isEmpty() || request.getParameter("moyenneSortie").isEmpty()
				|| request.getParameter("anneeDiplome").isEmpty()) {

			if (request.getParameter("nom").isEmpty())
				request.getSession().setAttribute("error_nom", "champ obligatoire");
			if (request.getParameter("prenom").isEmpty())
				request.getSession().setAttribute("error_prenom", "champ obligatoire");
			if (request.getParameter("nomArabe").isEmpty())
				request.getSession().setAttribute("error_nomArabe", "champ obligatoire");
			if (request.getParameter("prenomArabe").isEmpty())
				request.getSession().setAttribute("error_prenomArabe", "champ obligatoire");
			if (request.getParameter("email").isEmpty())
				request.getSession().setAttribute("error_email", "champ obligatoire");
			if (request.getParameter("cin").isEmpty())
				request.getSession().setAttribute("error_cin", "champ obligatoire");
			if (request.getParameter("dateNaissance").isEmpty())
				request.getSession().setAttribute("error_dateNaissance", "champ obligatoire");
			if (request.getParameter("lieuNaissance").isEmpty())
				request.getSession().setAttribute("error_lieuNaissance", "champ obligatoire");
			if (request.getParameter("adresse").isEmpty())
				request.getSession().setAttribute("error_adresse", "champ obligatoire");
			if (request.getParameter("telephone").isEmpty())
				request.getSession().setAttribute("error_telephone", "champ obligatoire");
			if (request.getParameter("cne").isEmpty())
				request.getSession().setAttribute("error_cne", "champ obligatoire");
			if (request.getParameter("intituleBac").isEmpty())
				request.getSession().setAttribute("error_intituleBac", "champ obligatoire");
			if (request.getParameter("anneeBac").isEmpty())
				request.getSession().setAttribute("error_anneeBac", "champ obligatoire");
			if (request.getParameter("diplome").isEmpty())
				request.getSession().setAttribute("error_diplome", "champ obligatoire");
			if (request.getParameter("intituleFiliere").isEmpty())
				request.getSession().setAttribute("error_intituleFiliere", "champ obligatoire");
			if (request.getParameter("etablissement").isEmpty())
				request.getSession().setAttribute("error_etablissement", "champ obligatoire");
			if (request.getParameter("ville").isEmpty())
				request.getSession().setAttribute("error_ville", "champ obligatoire");
			if (request.getParameter("moyenne1").isEmpty())
				request.getSession().setAttribute("error_moyenne1", "champ obligatoire");
			if (request.getParameter("moyenne2").isEmpty())
				request.getSession().setAttribute("error_moyenne2", "champ obligatoire");
			if (request.getParameter("moyenneSortie").isEmpty())
				request.getSession().setAttribute("error_moyenneSortie", "champ obligatoire");
			if (request.getParameter("anneeDiplome").isEmpty())
				request.getSession().setAttribute("error_anneeDiplome", "champ obligatoire");

			response.sendRedirect("../candidat/inscription.asp?idcandidature=" + request.getParameter("idCandidature"));

		} else {
			if (candidatDao.findByEmail(request.getParameter("email")) != null
					|| candidatDao.findByCne(request.getParameter("cne")) != null
					|| candidatDao.findByCin(request.getParameter("cin")) != null) {

				if (candidatDao.findByEmail(request.getParameter("email")) != null)
					request.getSession().setAttribute("error_email", "vous devez donné un autre email");
				if (candidatDao.findByCne(request.getParameter("cne")) != null)
					request.getSession().setAttribute("error_cne", "vous devez donné un autre cne");
				if (candidatDao.findByCin(request.getParameter("cin")) != null)
					request.getSession().setAttribute("error_cin", "vous devez donné un autre cin");
				response.sendRedirect(
						"../candidat/inscription.asp?idcandidature=" + request.getParameter("idCandidature"));
			} else {
				Candidat candidat = new Candidat();
				Candidature candidature = candidatureDao.find(Integer.parseInt(request.getParameter("idCandidature")));
				candidat.setNom(request.getParameter("nom"));
				candidat.setPrenom(request.getParameter("prenom"));
				candidat.setNomArabe(request.getParameter("nomArabe"));
				candidat.setPrenomArabe(request.getParameter("prenomArabe"));
				candidat.setCin(request.getParameter("cin"));
				candidat.setEmail(request.getParameter("email"));
				candidat.setPassword(request.getParameter("cne"));
				Date date = Date.valueOf(request.getParameter("dateNaissance"));
				candidat.setDataNaissance(date);
				candidat.setLieuNaissance(request.getParameter("lieuNaissance"));
				candidat.setAdresse(request.getParameter("adresse"));
				candidat.setTelephone(request.getParameter("telephone"));
				candidat.setCne(request.getParameter("cne"));
				candidat.setIntituleBac(request.getParameter("intituleBac"));
				candidat.setAnneeBac(Integer.parseInt(request.getParameter("anneeBac")));
				candidat.setDiplome(request.getParameter("diplome"));
				candidat.setIntituleFiliere(request.getParameter("intituleFiliere"));
				candidat.setEtablissement(request.getParameter("etablissement"));
				candidat.setVille(request.getParameter("ville"));
				candidat.setMoyenne1(Double.parseDouble(request.getParameter("moyenne1")));
				candidat.setMoyenne2(Double.parseDouble(request.getParameter("moyenne2")));
				candidat.setMoyenneSortie(Double.parseDouble(request.getParameter("moyenneSortie")));
				candidat.setAnneeDiplome(Integer.parseInt(request.getParameter("anneeDiplome")));
				candidat.setCandidature(candidature);
				Mailer mailer = new Mailer();
				mailer.sendMail(candidat.getEmail(), candidat.getPassword());
				candidatDao.add(candidat);

				request.getSession().removeAttribute("old_nom");
				request.getSession().removeAttribute("old_prenom");
				request.getSession().removeAttribute("old_nomArabe");
				request.getSession().removeAttribute("old_prenomArabe");
				request.getSession().removeAttribute("old_email");
				request.getSession().removeAttribute("old_cin");
				request.getSession().removeAttribute("old_dateNaissance");
				request.getSession().removeAttribute("old_lieuNaissance");
				request.getSession().removeAttribute("old_adresse");
				request.getSession().removeAttribute("old_telephone");
				request.getSession().removeAttribute("old_cne");
				request.getSession().removeAttribute("old_intituleBac");
				request.getSession().removeAttribute("old_anneeBac");
				request.getSession().removeAttribute("old_diplome");
				request.getSession().removeAttribute("old_intituleFiliere");
				request.getSession().removeAttribute("old_etablissement");
				request.getSession().removeAttribute("old_ville");
				request.getSession().removeAttribute("old_moyenne1");
				request.getSession().removeAttribute("old_moyenne2");
				request.getSession().removeAttribute("old_moyenneSortie");
				request.getSession().removeAttribute("old_anneeDiplome");

				request.getSession().setAttribute("inscription_success", true);
				response.sendRedirect("../candidat/inscription.asp?idcandidature=" + candidature.getId());
			}
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("nom").isEmpty() || request.getParameter("prenom").isEmpty()
				|| request.getParameter("nomArabe").isEmpty() || request.getParameter("prenomArabe").isEmpty()
				|| request.getParameter("email").isEmpty() || request.getParameter("cin").isEmpty()
				|| request.getParameter("dateNaissance").isEmpty() || request.getParameter("lieuNaissance").isEmpty()
				|| request.getParameter("adresse").isEmpty() || request.getParameter("telephone").isEmpty()
				|| request.getParameter("cne").isEmpty() || request.getParameter("intituleBac").isEmpty()
				|| request.getParameter("anneeBac").isEmpty() || request.getParameter("diplome").isEmpty()
				|| request.getParameter("intituleFiliere").isEmpty() || request.getParameter("etablissement").isEmpty()
				|| request.getParameter("ville").isEmpty() || request.getParameter("moyenne1").isEmpty()
				|| request.getParameter("moyenne2").isEmpty() || request.getParameter("moyenneSortie").isEmpty()
				|| request.getParameter("anneeDiplome").isEmpty()) {

			if (request.getParameter("nom").isEmpty())
				request.getSession().setAttribute("error_nom", "champ obligatoire");
			if (request.getParameter("prenom").isEmpty())
				request.getSession().setAttribute("error_prenom", "champ obligatoire");
			if (request.getParameter("nomArabe").isEmpty())
				request.getSession().setAttribute("error_nomArabe", "champ obligatoire");
			if (request.getParameter("prenomArabe").isEmpty())
				request.getSession().setAttribute("error_prenomArabe", "champ obligatoire");
			if (request.getParameter("email").isEmpty())
				request.getSession().setAttribute("error_email", "champ obligatoire");
			if (request.getParameter("cin").isEmpty())
				request.getSession().setAttribute("error_cin", "champ obligatoire");
			if (request.getParameter("dateNaissance").isEmpty())
				request.getSession().setAttribute("error_dateNaissance", "champ obligatoire");
			if (request.getParameter("lieuNaissance").isEmpty())
				request.getSession().setAttribute("error_lieuNaissance", "champ obligatoire");
			if (request.getParameter("adresse").isEmpty())
				request.getSession().setAttribute("error_adresse", "champ obligatoire");
			if (request.getParameter("telephone").isEmpty())
				request.getSession().setAttribute("error_telephone", "champ obligatoire");
			if (request.getParameter("cne").isEmpty())
				request.getSession().setAttribute("error_cne", "champ obligatoire");
			if (request.getParameter("intituleBac").isEmpty())
				request.getSession().setAttribute("error_intituleBac", "champ obligatoire");
			if (request.getParameter("anneeBac").isEmpty())
				request.getSession().setAttribute("error_anneeBac", "champ obligatoire");
			if (request.getParameter("diplome").isEmpty())
				request.getSession().setAttribute("error_diplome", "champ obligatoire");
			if (request.getParameter("intituleFiliere").isEmpty())
				request.getSession().setAttribute("error_intituleFiliere", "champ obligatoire");
			if (request.getParameter("etablissement").isEmpty())
				request.getSession().setAttribute("error_etablissement", "champ obligatoire");
			if (request.getParameter("ville").isEmpty())
				request.getSession().setAttribute("error_ville", "champ obligatoire");
			if (request.getParameter("moyenne1").isEmpty())
				request.getSession().setAttribute("error_moyenne1", "champ obligatoire");
			if (request.getParameter("moyenne2").isEmpty())
				request.getSession().setAttribute("error_moyenne2", "champ obligatoire");
			if (request.getParameter("moyenneSortie").isEmpty())
				request.getSession().setAttribute("error_moyenneSortie", "champ obligatoire");
			if (request.getParameter("anneeDiplome").isEmpty())
				request.getSession().setAttribute("error_anneeDiplome", "champ obligatoire");

			response.sendRedirect("../candidat/candidat.asp");

		} else {
			Candidat candidat1 = new Candidat();
			Candidat candidat2 = (Candidat) request.getSession().getAttribute("candidat");
			candidat1.setId(candidat2.getId());
			Candidature candidature = candidatureDao.find(Integer.parseInt(request.getParameter("idCandidature")));
			candidat1.setNom(request.getParameter("prenom"));
			candidat1.setPrenom(request.getParameter("prenom"));
			candidat1.setNomArabe(request.getParameter("nomArabe"));
			candidat1.setPrenomArabe(request.getParameter("prenomArabe"));
			candidat1.setCin(request.getParameter("cin"));
			candidat1.setEmail(request.getParameter("email"));
			candidat1.setPassword(request.getParameter("cne"));
			Date date = Date.valueOf(request.getParameter("dateNaissance"));
			candidat1.setDataNaissance(date);
			candidat1.setLieuNaissance(request.getParameter("lieuNaissance"));
			candidat1.setAdresse(request.getParameter("adresse"));
			candidat1.setTelephone(request.getParameter("telephone"));
			candidat1.setCne(request.getParameter("cne"));
			candidat1.setIntituleBac(request.getParameter("intituleBac"));
			candidat1.setAnneeBac(Integer.parseInt(request.getParameter("anneeBac")));
			candidat1.setDiplome(request.getParameter("diplome"));
			candidat1.setIntituleFiliere(request.getParameter("intituleFiliere"));
			candidat1.setEtablissement(request.getParameter("etablissement"));
			candidat1.setVille(request.getParameter("ville"));
			candidat1.setMoyenne1(Double.parseDouble(request.getParameter("moyenne1")));
			candidat1.setMoyenne2(Double.parseDouble(request.getParameter("moyenne2")));
			candidat1.setMoyenneSortie(Double.parseDouble(request.getParameter("moyenneSortie")));
			candidat1.setAnneeDiplome(Integer.parseInt(request.getParameter("anneeDiplome")));
			candidat1.setCandidature(candidature);
			
			try {
				candidatDao.update(candidat1);
				Mailer mailer = new Mailer();
				mailer.sendMail(candidat1.getEmail(), candidat1.getPassword());
				request.getSession().setAttribute("modification_success", true);
				request.getSession().setAttribute("candidat", candidat1);
				response.sendRedirect("../candidat/candidat.asp");
			}catch(Exception e) {
				request.getSession().setAttribute("error", "Verifier l'email, cin,cne données");
				response.sendRedirect("../candidat/candidat.asp");
			}
		}
	}
}
