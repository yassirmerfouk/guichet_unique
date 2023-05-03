<%@ include file="/WEB-INF/app/includes/layout-part1.jsp"%>

<div class="card-box mb-30">
	<div class="pd-20 row">
		<div class="pd-10">
			<h4 class="text-blue h4">Liste des Candidatures</h4>
		</div>
		<div class="ml-auto pd-10">
			<a href="../admin/ajoutercandidature.asp" class="btn btn-primary">Ajouter une candidature</a>
		</div>
	</div>
	<div class="pb-20 ml-3 mr-3">
		<table class="data-table table stripe hover nowrap border">
			<thead>
				<tr>
					<th class="table-plus datatable-nosort">Id</th>
					<th>Nom Candidature</th>
					<th>Nom Filiere</th>
					<th class="datatable-nosort">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${candidatures }" var="candidature">
					<tr>
						<td class="table-plus">${candidature.id }</td>
						<td>${candidature.nom }</td>
						<td>${candidature.filiere.nom}</td>
						<td>
							<div class="dropdown">
								<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown"> <i class="dw dw-more"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
									<a class="dropdown-item" href="../admin/modifiercandidature.asp?idcandidature=${candidature.id }"><i class="dw dw-edit2"></i> Modifier</a>
									<form action="../admin/supprimercandidature.asp?idcandidature=${candidature.id }" method="POST">
										<button type="submit" class="dropdown-item" onclick="myFunction()">
											<i class="dw dw-delete-3"></i> Supprimer</a>
									</form>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<!-- Simple Datatable End -->

<script>
	function myFunction() {
		alert("Vous voullez vraiment supprimer cette candidature ?");
	}
</script>

<c:if test="${not empty add_success }">
	<script>
		Swal.fire({
			position : 'top-end',
			icon : 'success',
			title : 'La candidature est ajoutée avec succèss',
			showConfirmButton : true,
			timer : 4000
		})
	</script>
	<c:remove var="add_success" scope="session" />
</c:if>
<c:if test="${not empty update_success }">
	<script>
		Swal.fire({
			position : 'top-end',
			icon : 'success',
			title : 'La candidature est modifié avec succèss',
			showConfirmButton : true,
			timer : 4000
		})
	</script>
	<c:remove var="update_success" scope="session" />
</c:if>
<c:if test="${not empty delete_success }">
	<script>
		Swal.fire({
			position : 'top-end',
			icon : 'success',
			title : 'La candidature est supprimée avec succèss',
			showConfirmButton : true,
			timer : 4000
		})
	</script>
	<c:remove var="delete_success" scope="session" />
</c:if>

<%@ include file="/WEB-INF/app/includes/layout-part2.jsp"%>