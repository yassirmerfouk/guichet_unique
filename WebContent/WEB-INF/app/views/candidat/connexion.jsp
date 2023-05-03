<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<title>Connexion Candidat</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="<%=application.getInitParameter("STYLES_PATH")%>/logincandidat/css/style.css">

</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-5">
					<div class="login-wrap p-4 p-md-5">
						<div class="icon d-flex align-items-center justify-content-center">
							<span class="fa fa-user-o"></span>
						</div>
						<h3 class="text-center mb-4">CONNEXION</h3>
						<form action="../candidat/connexion.asp" method="POST" class="login-form">
							<div class="form-group">
								<input type="text" class="form-control rounded-left ${empty error_login ? '' : 'is-invalid' }" placeholder="Email" name="login" value="${empty old_email ? '' : old_email }">
								<c:remove var="old_email" scope="session" />
							</div>
							<div class="form-group d-flex">
								<input type="password" class="form-control rounded-left" placeholder="Mot de passe" name="password">
							</div>
							<div class="form-group">
								<button type="submit" class="form-control btn btn-primary rounded submit px-3">Connexion</button>
							</div>
							<div class="form-group d-md-flex">
							</div>
							<c:remove var="error_login" scope="session" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="<%=application.getInitParameter("STYLES_PATH")%>/logincandidat/js/jquery.min.js"></script>
	<script src="<%=application.getInitParameter("STYLES_PATH")%>/logincandidat/js/popper.js"></script>
	<script src="<%=application.getInitParameter("STYLES_PATH")%>/logincandidat/js/bootstrap.min.js"></script>
	<script src="<%=application.getInitParameter("STYLES_PATH")%>/logincandidat/js/main.js"></script>

</body>
</html>

