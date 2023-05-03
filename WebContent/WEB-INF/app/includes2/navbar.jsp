
<header>
	<div class="my-nav">
		<div class="container">
			<div class="row">
				<div class="nav-items">
					<div class="menu-toggle"></div>
					<div class="logo">
						<img src="<%=application.getInitParameter("STYLES_PATH")%>assets2/images/logo-01.png">
					</div>
					<div class="menu-items">
						<div class="menu">
							<ul>
								<li><a href="../candidat/accueil.asp">Accueil</a></li>
								<li><a href="../candidat/candidatures.asp">Candidatures</a></li>
								<li><a href="">Modules</a></li>
								<li><a href="http://www.ests.uca.ma" target="_blank">ESTS</a></li>
								<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false"> Connexion </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" style="color: black;" href="../candidat/connexion.asp">Connexion candidat</a>
									<a class="dropdown-item" style="color: black;" href="../admin/connexion.asp">Connexion admin</a>
										<div class="dropdown-divider"></div>
									</div></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>

<section id="carouselExampleFade" class="carousel slide carousel-fade slider" data-ride="carousel">
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="<%=application.getInitParameter("STYLES_PATH")%>assets2/images/slider/ests.png" class="d-block" alt="...">
			<div class="carousel-caption">
				<h2>ÉCOLE SUPÉRIEURE DE TECHNOLOGIE-SAFI</h2>
				<p></p>
				<div class="button-01">
					<ul>
						<li><a href="../candidat/candidatures.asp">Inscription Licence</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</section>