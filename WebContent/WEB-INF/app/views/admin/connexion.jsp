<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Basic Page Info -->
<meta charset="utf-8">
<title>Guichet Licence</title>

<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="<%=application.getInitParameter("STYLES_PATH")%>vendors/styles/core.css">
<link rel="stylesheet" type="text/css" href="<%=application.getInitParameter("STYLES_PATH")%>vendors/styles/icon-font.min.css">
<link rel="stylesheet" type="text/css" href="<%=application.getInitParameter("STYLES_PATH")%>vendors/styles/style.css">

</head>
<body class="login-page">
	<div class="login-header box-shadow">
		<div class="container-fluid d-flex justify-content-between align-items-center">
			<div class="brand-logo">
				<a href="login.html"> <img src="<%=application.getInitParameter("STYLES_PATH")%>vendors/images/deskapp-logo.svg" alt="">
				</a>
			</div>
			<div class="login-menu">
				<ul>
					<li><a href="../candidat/accueil.asp">Candidat</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-md-6 col-lg-7">
					<img src="<%=application.getInitParameter("STYLES_PATH")%>vendors/images/login-page-img.png" alt="">
				</div>
				<div class="col-md-6 col-lg-5">
					<div class="login-box bg-white box-shadow border-radius-10">
						<div class="login-title">
							<h2 class="text-center text-primary">Se Connecter</h2>
						</div>
						<c:if test="${not empty error_login }">
							<div class="alert alert-danger text-center" role="alert">
								<c:out value="${error_login }" />
							</div>
						</c:if>
						<form action="../admin/connexion.asp" method="POST">
							<div class="input-group custom">
								<input type="text" class="form-control form-control-lg ${empty error_login ? '' : 'is-invalid' }" placeholder="Email" name="login" value="${empty old_email ? '' : old_email }">
								<c:remove var="old_email" scope="session" />
								<div class="input-group-append custom"></div>
							</div>
							<div class="input-group custom">
								<input type="password" class="form-control form-control-lg ${empty error_login ? '' : 'is-invalid' }" placeholder="Password" name="password">
								<div class="input-group-append custom"></div>
							</div>
							<div class="row pb-30">
								<div class="col-6">
									<div class="custom-control custom-checkbox">
										<input type="checkbox" class="custom-control-input" id="customCheck1"> <label class="custom-control-label" for="customCheck1">Remember</label>
									</div>
								</div>
								<div class="col-6">
									<div class="forgot-password">
										<a href="">Forgot Password</a>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<div class="input-group mb-0">
										<button type="submit" class="btn btn-primary btn-lg btn-block">Se connecter</button>
									</div>
								</div>
							</div>
							<c:remove var="error_login" scope="session" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- js -->
	<script src="<%=application.getInitParameter("STYLES_PATH")%>vendors/scripts/core.js"></script>
	<script src="<%=application.getInitParameter("STYLES_PATH")%>vendors/scripts/script.min.js"></script>
	<script src="<%=application.getInitParameter("STYLES_PATH")%>vendors/scripts/process.js"></script>
	<script src="<%=application.getInitParameter("STYLES_PATH")%>vendors/scripts/layout-settings.js"></script>
</body>
</html>