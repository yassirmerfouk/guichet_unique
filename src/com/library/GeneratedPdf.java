package com.library;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CandidatDAO;
import com.entities.Candidat;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

public class GeneratedPdf {

	public void generatePdf(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Candidat candidat = null;
		if (request.getSession().getAttribute("candidat") != null)
			candidat = (Candidat) request.getSession().getAttribute("candidat");
		else
			candidat = new CandidatDAO().find(Integer.parseInt(request.getParameter("idcandidat")));
		String masterPath = request.getServletContext().getRealPath("/WEB-INF/app/pdf/pdf.pdf");
		response.setContentType("application/pdf");

		try (PdfReader reader = new PdfReader(masterPath);
				PdfWriter writer = new PdfWriter(response.getOutputStream());
				PdfDocument document = new PdfDocument(reader, writer);) {

			PdfPage page = document.getPage(1);
			PdfCanvas canvas = new PdfCanvas(page);

			FontProgram fontProgram = FontProgramFactory.createFont();
			PdfFont font = PdfFontFactory.createFont(fontProgram, "utf-8", true);
			canvas.setFontAndSize(font, 12);

			canvas.beginText();

			canvas.setTextMatrix(305, 578);
			canvas.showText(candidat.getNom());
			canvas.setTextMatrix(305, 558);
			canvas.showText(candidat.getPrenom());
			canvas.setTextMatrix(305, 538);
			canvas.showText(candidat.getNomArabe());
			canvas.setTextMatrix(305, 518);
			canvas.showText(candidat.getPrenomArabe());
			canvas.setTextMatrix(305, 498);
			canvas.showText(candidat.getEmail());
			canvas.setTextMatrix(305, 478);
			canvas.showText(candidat.getCin());
			canvas.setTextMatrix(305, 458);
			canvas.showText(candidat.getDataNaissance().toString());
			canvas.setTextMatrix(305, 438);
			canvas.showText(candidat.getLieuNaissance());
			canvas.setTextMatrix(305, 420);
			canvas.showText(candidat.getAdresse());
			canvas.setTextMatrix(305, 400);
			canvas.showText(candidat.getTelephone());
			canvas.setTextMatrix(305, 382);
			canvas.showText(candidat.getCne());
			canvas.setTextMatrix(305, 361);
			canvas.showText(candidat.getIntituleBac());
			canvas.setTextMatrix(305, 342);
			canvas.showText(Integer.toString(candidat.getAnneeBac()));
			canvas.setTextMatrix(305, 325);
			canvas.showText(candidat.getDiplome());
			canvas.setTextMatrix(305, 305);
			canvas.showText(candidat.getIntituleFiliere());
			canvas.setTextMatrix(305, 285);
			canvas.showText(candidat.getEtablissement());
			canvas.setTextMatrix(305, 266);
			canvas.showText(candidat.getVille());
			canvas.setTextMatrix(305, 246);
			canvas.showText(Double.toString(candidat.getMoyenne1()));
			canvas.setTextMatrix(305, 226);
			canvas.showText(Double.toString(candidat.getMoyenne2()));
			canvas.setTextMatrix(305, 210);
			canvas.showText(Double.toString(candidat.getMoyenneSortie()));
			canvas.setTextMatrix(305, 189);
			canvas.showText(Integer.toString(candidat.getAnneeDiplome()));
			canvas.setTextMatrix(305, 171);
			canvas.showText(candidat.getCandidature().getFiliere().getNom());

			canvas.endText();

		}
	}
}
