<%@ include file="/WEB-INF/app/includes/layout-part1.jsp"%>

<div class="card-box mb-30">
	<div class="pd-20 row">
		<div class="pd-10">
			<h4 class="text-blue h4">Liste des Candidats</h4>
		</div>
	</div>
	<div class="pb-20 ml-3 mr-3">

		<form action="../admin/candidats.asp" method="POST" />
		<div class="form-row">
			<div class="col-md-6 mb-3">
				<div class="form-group">
					<select class="custom-select2 form-control" name="idCandidature" style="width: 100%; height: 38px;">
						<c:forEach items="${candidatures }" var="candidature">
							<option value="${candidature.id }">${candidature.nom }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-6 mb-3">
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Chercher par candidature</button>
				</div>
			</div>
		</div>
		</form>

		<table class="data-table table stripe hover nowrap border">
			<thead>
				<tr>
					<th class="table-plus datatable-nosort">Nom</th>
					<th>Prenom</th>
					<th>CNE</th>
					<th>Filiere</th>
					<th class="datatable-nosort">PDF</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${candidats }" var="candidat">
					<tr>
						<td class="table-plus">${candidat.nom }</td>
						<td>${candidat.prenom }</td>
						<td>${candidat.cne}</td>
						<td>${candidat.candidature.nom}</td>
						<td><a href="../admin/pdfcandidat.asp?idcandidat=${candidat.id }" target="_blank"><i class="fa fa-file-pdf-o" aria-hidden="true"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<!-- Simple Datatable End -->

<%@ include file="/WEB-INF/app/includes/layout-part2.jsp"%>