<%@ include file="/WEB-INF/app/includes/layout-part1.jsp"%>

<div class="blog-wrap">
	<div class="container pd-0">
		<div class="row">
			<div class="col-md-9 col-sm-12">
				<div class="album">
					<div class="container">

						<div class="row">
							<c:forEach items="${candidatures }" var="candidature">
								<div class="col-md-6">
									<div class="card mb-4 box-shadow">
										<img class="card-img-top" src="<%=application.getInitParameter("STYLES_PATH")%>img/default_course.jpg" alt="Card image cap">
										<div class="card-body">
											<p class="card-text">${candidature.nom }</p>
											<div class="d-flex justify-content-between align-items-center">
												<div class="btn-group ">
													<a href="" class="btn btn-sm btn-outline-secondary mr-2">Consulter</a> <a href="../admin/modifiercandidature.asp?idcandidature=${candidature.id }" class="btn btn-sm btn-outline-secondary">Modifier</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-sm-12">
				<div class="card-box mb-30">
					<h5 class="pd-20 h5 mb-0">Filieres</h5>
					<div class="latest-post">
						<ul>
							<c:forEach items="${filieres }" var="filiere">
								<li>
									<h4>
										<a href="../admin/modules.asp?idfiliere=${filiere.id }">${filiere.nom }</a>
									</h4>
								</li>
							</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/app/includes/layout-part2.jsp"%>