<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	<div class="header-left"></div>
	<div class="header-right">
		<div class="user-info-dropdown">
			<div class="dropdown">
				<a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown"> <span class="user-icon"> <img src="<%=application.getInitParameter("STYLES_PATH")%>vendors/images/photo1.jpg" alt="">
				</span> <c:if test="${not empty admin }">
						<span class="user-name">${admin.email }</span>
					</c:if> <c:if test="${not empty candidat }">
						<span class="user-name">${candidat.nom } ${candidat.prenom }</span>
					</c:if>
				</a>
				<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
					<a class="dropdown-item" href=""><i class="dw dw-user1"></i> Profile</a>
					<c:if test="${not empty admin }">
						<a class="dropdown-item" href="../admin/deconnexion.asp"><i class="dw dw-logout"></i> Log Out</a>
					</c:if>
					<c:if test="${not empty candidat }">
						<a class="dropdown-item" href="../candidat/deconnexion.asp"><i class="dw dw-logout"></i> Log Out</a>
					</c:if>
				</div>
			</div>
		</div>
		<div class="github-link">
			<a href=""><img src="<%=application.getInitParameter("STYLES_PATH")%>vendors/images/github.svg" alt=""></a>
		</div>
	</div>
</div>