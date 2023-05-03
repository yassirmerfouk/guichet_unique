package com.library;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.services.ServiceAuth;
import com.services.ServiceCandidat;
import com.services.ServiceCandidature;
import com.services.ServiceFiliere;
import com.services.ServiceModule;


public class FrontController extends HttpServlet{

	private String _controller;
	private String _action;
	
	@Override
	public void init() throws ServletException {
		getServletContext().setAttribute("serviceAuth", new ServiceAuth());
		getServletContext().setAttribute("serviceFiliere", new ServiceFiliere());
		getServletContext().setAttribute("serviceModule", new ServiceModule());
		getServletContext().setAttribute("serviceCandidature", new ServiceCandidature());
		getServletContext().setAttribute("serviceCandidat", new ServiceCandidat());
		getServletContext().setAttribute("generatedPdf", new GeneratedPdf());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatchRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	public void dispatchRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		_controller = "";
		_action = "";
		
		String path = req.getServletPath().substring(1, req.getServletPath().length() - 4);
		if (!path.isEmpty()) {
			String[] uri = path.split("/", 2);
			_controller = uri[0].substring(0, 1).toUpperCase() + uri[0].substring(1) + "Controller";
			if (uri.length > 1 && !uri[1].isEmpty()) {
				_action = uri[1];
			}
		}
		
//		System.out.println("controller : "+ _controller);
//		System.out.println("method : "+ _action);
		
		try {
			Class controllerClass = Class.forName("com.controllers." + _controller);
			Controller controller = (Controller) controllerClass.getDeclaredConstructor(HttpServletRequest.class).newInstance(req);
			Method method = controllerClass.getMethod(_action, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(controller, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(404);
		}
	}
}
