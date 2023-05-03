<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="left-side-bar">
	<div class="brand-logo">
		<a href=""> <img src="<%=application.getInitParameter("STYLES_PATH")%>vendors/images/deskapp-logo.svg" alt="" class="dark-logo"> <img
			src="<%=application.getInitParameter("STYLES_PATH")%>vendors/images/deskapp-logo-white.svg" alt="" class="light-logo">
		</a>
		<div class="close-sidebar" data-toggle="left-sidebar-close">
			<i class="ion-close-round"></i>
		</div>
	</div>
	<div class="menu-block customscroll">
		<div class="sidebar-menu">
			<c:if test="${not empty admin }">
				<ul id="accordion-menu">
					<li class="dropdown"><a href="../admin/accueil.asp" class="dropdown-toggle"> <span class="micon dw dw-house-1"></span><span class="mtext">Home</span>
					</a></li>
					<li class="dropdown"><a href="javascript:;" class="dropdown-toggle"> <span class="micon dw dw-house-1"></span><span class="mtext">Filieres</span>
					</a>
						<ul class="submenu">
							<li><a href="../admin/ajouterfiliere.asp">Ajouter Filieres</a></li>
							<li><a href="../admin/filieres.asp">Liste Filieres</a></li>
						</ul></li>
					<li class="dropdown"><a href="javascript:;" class="dropdown-toggle"> <span class="micon dw dw-house-1"></span><span class="mtext">Modules</span>
					</a>
						<ul class="submenu">
							<li><a href="../admin/ajoutermodule.asp">Ajouter Module</a></li>
						</ul></li>
					<li class="dropdown"><a href="javascript:;" class="dropdown-toggle"> <span class="micon dw dw-house-1"></span><span class="mtext">Candidatures</span>
					</a>
						<ul class="submenu">
							<li><a href="../admin/ajoutercandidature.asp">Ajouter Candidature</a></li>
							<li><a href="../admin/candidatures.asp">Liste Candidatures</a></li>
						</ul></li>
					<li class="dropdown"><a href="javascript:;" class="dropdown-toggle"> <span class="micon dw dw-house-1"></span><span class="mtext">Candidats</span>
					</a>
						<ul class="submenu">
							<li><a href="../admin/candidats.asp">Liste Candidats</a></li>
						</ul></li>
					<li><a href="" class="dropdown-toggle no-arrow"> <span class="micon dw dw-paper-plane1"></span> <span class="mtext">Landing Page </span>
					</a></li>
				</ul>
			</c:if>
			<c:if test="${not empty candidat }">
				<ul id="accordion-menu">
					<li class="dropdown"><a href="" class="dropdown-toggle"> <span class="micon dw dw-house-1"></span><span class="mtext">Ma cnadidature</span>
					</a></li>
				</ul>
			</c:if>
		</div>
	</div>
</div>
<div class="mobile-menu-overlay"></div>