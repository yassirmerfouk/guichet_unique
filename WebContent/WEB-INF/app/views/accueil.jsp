<%@ include file="/WEB-INF/app/includes2/layout-part1.jsp"%>

<section class="bg-04 p-4">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="heading">
					<h2>Candidatures Licence Professionnelle</h2>
					<p></p>
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${candidatures }" var="candidature">
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<a href="../candidat/inscription.asp?idcandidature=${candidature.id }">
						<article class="_lk_bg_sd_we">
							<div class="_bv_xs_we" style="background:url(<%=application.getInitParameter("STYLES_PATH")%>img/image.png"></div>
							<div class="_xs_we_er">
								<div class="_he_w">
									<h3>${candidature.nom }</h3>
									<ol class="mt-2">
										<li>Date ouverture <span class="_mn_cd_xs">${candidature.dateOuverture }</span></li>
										<li>Date limité <span class="_mn_cd_xs">${candidature.dateLimite }</span></li>
									</ol>
								</div>
							</div>
					</a>
					</article>
				</div>
			</c:forEach>
		</div>
	</div>
</section>

<section class="bg-04 p-1">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="heading">
					<h2>Filieres Licence Professionnelle</h2>
					<p></p>
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${filieres}" var="filiere">
				<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
					<a href="">
						<article class="_lk_bg_sd_we">
							<div class="_bv_xs_we" style="background:url(<%=application.getInitParameter("STYLES_PATH")%>img/image.png"></div>
							<div class="_xs_we_er">
								<div class="_he_w">
									<h3>${filiere.nom }</h3>
									<ol class="mt-2">
										<li>LP <span class="_mn_cd_xs">${filiere.nom }</span></li>
									</ol>
								</div>
							</div>
						</article>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
</section>

<%@ include file="/WEB-INF/app/includes2/layout-part2.jsp"%>

