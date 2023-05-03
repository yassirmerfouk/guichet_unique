<%@ include file="/WEB-INF/app/includes2/layout-part1.jsp"%>

<section class="bg-04 p-1 pb-4">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="heading">
					<h2>Incription Licence Professionnelle</h2>
					<p></p>
				</div>
			</div>
		</div>

		<div class="card-body border" style="background-color: white;">
			<div class="clearfix mb-4">
				<h4 class="text-blue h4">${candidature.nom }</h4>
			</div>
			<div class="wizard-content">
				<form class="" action="../candidat/inscription.asp" method="POST">
					<h5></h5>
					<section>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Nom :</label> <input type="text" class="form-control" name="nom" value="${old_nom }">
									<c:if test="${not empty error_nom }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_nom }</div>
										<c:remove var="error_nom" scope="session" />
									</c:if>
									<c:remove var="old_nom" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Prenom :</label> <input type="text" class="form-control" name="prenom" value="${old_prenom }">
									<c:if test="${not empty error_prenom }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_prenom }</div>
										<c:remove var="error_prenom" scope="session" />
									</c:if>
									<c:remove var="old_prenom" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Nom Arabe:</label> <input type="text" class="form-control" name="nomArabe" value="${old_nomArabe }">
									<c:if test="${not empty error_nomArabe }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_nomArabe }</div>
										<c:remove var="error_nomArabe" scope="session" />
									</c:if>
									<c:remove var="old_nomArabe" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Prenom Arabe :</label> <input type="text" class="form-control" name="prenomArabe" value="${old_prenomArabe }">
									<c:if test="${not empty error_prenomArabe }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_prenomArabe }</div>
										<c:remove var="error_prenomArabe" scope="session" />
									</c:if>
									<c:remove var="old_prenomArabe" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Email :</label> <input type="email" class="form-control" name="email" value="${old_email }">
									<c:if test="${not empty error_email }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_email }</div>
										<c:remove var="error_email" scope="session" />
									</c:if>
									<c:remove var="old_email" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>CIN :</label> <input type="text" class="form-control" name="cin" value="${old_cin }">
									<c:if test="${not empty error_cin }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_cin }</div>
										<c:remove var="error_cin" scope="session" />
									</c:if>
									<c:remove var="old_cin" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Date de Naissance :</label> <input type="date" class="form-control" name="dateNaissance" value="${old_dateNaissance }">
									<c:if test="${not empty error_dateNaissance }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_dateNaissance }</div>
										<c:remove var="error_dateNaissance" scope="session" />
									</c:if>
									<c:remove var="old_dateNaissance" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Lieu de Naissance :</label> <input type="text" class="form-control" name="lieuNaissance" value="${old_lieuNaissance }">
									<c:if test="${not empty error_lieuNaissance }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_lieuNaissance }</div>
										<c:remove var="error_lieuNaissance" scope="session" />
									</c:if>
									<c:remove var="old_lieuNaissance" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Adresse :</label> <input type="text" class="form-control" name="adresse" value="${old_adresse }">
									<c:if test="${not empty error_adresse }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_adresse }</div>
										<c:remove var="error_adresse" scope="session" />
									</c:if>
									<c:remove var="old_adresse" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Téléphone:</label> <input type="text" class="form-control" name="telephone" value="${old_telephone }">
									<c:if test="${not empty error_telephone }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_telephone }</div>
										<c:remove var="error_telephone" scope="session" />
									</c:if>
									<c:remove var="old_telephone" scope="session" />
								</div>
							</div>
						</div>
					</section>
					<!-- Step 2 -->
					<h5></h5>
					<section>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>CNE :</label> <input type="text" class="form-control" name="cne" value="${old_cne }">
									<c:if test="${not empty error_cne }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_cne }</div>
										<c:remove var="error_cne" scope="session" />
									</c:if>
									<c:remove var="old_cne" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Intitulé Bac :</label> <input type="text" class="form-control" name="intituleBac" value="${old_intituleBac }">
									<c:if test="${not empty error_intituleBac }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_intituleBac }</div>
										<c:remove var="error_intituleBac" scope="session" />
									</c:if>
									<c:remove var="old_intituleBac" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Année Bac :</label> <select class="form-control" name="anneeBac">
										<option value="2022">2022</option>
										<option value="2021">2021</option>
										<option value="2020">2020</option>
										<option value="2019">2019</option>
										<option value="2018">2018</option>
										<option value="2017">2017</option>
										<option value="2016">2016</option>
										<option value="2015">2015</option>
										<c:if test="${not empty old_anneeBac }">
										<option value="${old_anneeBac }" selected >${old_anneeBac }</option>
										</c:if>
									</select>
									<c:if test="${not empty error_anneeBac }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_anneeBac }</div>
										<c:remove var="error_anneeBac" scope="session" />
									</c:if>
									<c:remove var="old_anneeBac" scope="session" />
								</div>
							</div>
						</div>
					</section>
					<!-- Step 3 -->
					<h5></h5>
					<section>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Diplome :</label> <select class="form-control" name="diplome">
										<option value="DUT">DUT</option>
										<option value="DEUG">DEUG</option>
										<option value="BTS">BTS</option>
										<option value="DTS">DTS</option>
										<c:if test="${not empty old_diplome }">
										<option value="${old_diplome}" selected >${old_diplome}</option>
										</c:if>
									</select>
									<c:if test="${not empty error_diplome }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_diplome }</div>
										<c:remove var="error_diplome" scope="session" />
									</c:if>
									<c:remove var="old_diplome" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Intitulé Filière :</label> <input type="text" class="form-control" name="intituleFiliere" value="${old_intituleFiliere}">
									<c:if test="${not empty error_intituleFiliere }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_intituleFiliere }</div>
										<c:remove var="error_intituleFiliere" scope="session" />
									</c:if>
									<c:remove var="old_intituleFiliere" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Etablissement :</label> <input type="text" class="form-control" name="etablissement" value="${old_etablissement}">
									<c:if test="${not empty error_etablissement }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_etablissement }</div>
										<c:remove var="error_etablissement" scope="session" />
									</c:if>
									<c:remove var="old_etablissement" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Ville :</label> <input type="text" class="form-control" name="ville" value="${old_ville}">
									<c:if test="${not empty error_ville }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_ville }</div>
										<c:remove var="error_ville" scope="session" />
									</c:if>
									<c:remove var="old_ville" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Note Première Année :</label> <input type="number" min="0" max="20" step="0.01" class="form-control" name="moyenne1" value="${old_moyenne1}">
									<c:if test="${not empty error_moyenne1 }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_moyenne1 }</div>
										<c:remove var="error_moyenne1" scope="session" />
									</c:if>
									<c:remove var="old_moyenne1" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Note Deusième Année :</label> <input type="number" min="0" max="20" step="0.01" class="form-control" name="moyenne2" value="${old_moyenne2}">
									<c:if test="${not empty error_moyenne2 }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_moyenne2 }</div>
										<c:remove var="error_moyenne2" scope="session" />
									</c:if>
									<c:remove var="old_moyenne2" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Moyenne de sortie :</label> <input type="number" min="0" max="20" step="0.01" class="form-control" name="moyenneSortie" value="${old_moyenneSortie}">
									<c:if test="${not empty error_moyenneSortie }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_moyenneSortie }</div>
										<c:remove var="error_moyenneSortie" scope="session" />
									</c:if>
									<c:remove var="old_moyenneSortie" scope="session" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Année de diplome :</label> <select class="form-control" name="anneeDiplome">
										<option value="2022">2022</option>
										<option value="2021">2021</option>
										<option value="2020">2020</option>
										<option value="2019">2019</option>
										<option value="2018">2018</option>
										<option value="2017">2017</option>
										<option value="2016">2016</option>
										<option value="2015">2015</option>
										<c:if test="${not empty old_anneeDiplome }">
										<option value="${old_anneeDiplome}" selected >${old_anneeDiplome}</option>
										</c:if>
									</select>
									<c:if test="${not empty error_anneeDiplome }">
										<div class="form-control-feedback text-danger mt-1 ml-1">${error_anneeDiplome }</div>
										<c:remove var="error_anneeDiplome" scope="session" />
									</c:if>
									<c:remove var="old_anneeDiplome" scope="session" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Filière de choix :</label> <select class="form-control" name="idCandidature">
										<option value="${candidature.id }">${candidature.filiere.nom }</option>
									</select>
								</div>
							</div>
						</div>
					</section>
					<button type="submit" class="btn btn-primary" style="background-color: #002147;">Envoyer</button>
				</form>
			</div>
		</div>

	</div>
</section>

<c:if test="${not empty inscription_success }">
	<script>
		Swal.fire({
			position : 'top-end',
			icon : 'success',
			title : 'Votre candidature est envoyé avec succès, merci de verifier votre boite email pour avoir les autres informations',
			showConfirmButton : true
		})
	</script>
	<c:remove var="inscription_success" scope="session" />
</c:if>


<%@ include file="/WEB-INF/app/includes2/layout-part2.jsp"%>