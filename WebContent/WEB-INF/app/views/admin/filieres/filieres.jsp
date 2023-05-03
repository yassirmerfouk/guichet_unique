<%@ include file="/WEB-INF/app/includes/layout-part1.jsp"%>

<!-- Simple Datatable start -->
<div class="card-box mb-30">
	<div class="pd-20 row">
		<div class="pd-10">
			<h4 class="text-blue h4">Liste des Filières</h4>
		</div>
		<div class="ml-auto pd-10">
			<a href="../admin/ajouterfiliere.asp" class="btn btn-primary">Ajouter une filière</a>
		</div>
	</div>
	<div class="pb-20 ml-3 mr-3">
		<table class="data-table table stripe hover nowrap border">
			<thead>
				<tr>
					<th class="table-plus datatable-nosort">Id</th>
					<th>Nom Filiere</th>
					<th>LP</th>
					<th class="datatable-nosort">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${filieres }" var="filiere">
					<tr>
						<td class="table-plus">${filiere.id }</td>
						<td>${filiere.nom }</td>
						<td>LP</td>
						<td>
							<div class="dropdown">
								<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown"> <i class="dw dw-more"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
									<a class="dropdown-item" href="../admin/modules.asp?idfiliere=${filiere.id }"><i class="dw dw-eye"></i> Consulter</a> <a class="dropdown-item" href="../admin/modifierfiliere.asp?idfiliere=${filiere.id }"><i
										class="dw dw-edit2"></i> Modifier</a>
									<form action="../admin/supprimerfiliere.asp" method="POST">
										<input type="hidden" name="idfiliere" value="${filiere.id }" />
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
		alert("Vous voullez vraiment supprimer cette filiere?");
	}
</script>

<c:if test="${not empty add_success }">
	<script>
		Swal.fire({
			position : 'top-end',
			icon : 'success',
			title : 'La filiere est ajoutée avec succèss',
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
			title : 'La filiere est modifiée avec succèss',
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
			title : 'La filiere est supprimée avec succèss',
			showConfirmButton : true,
			timer : 4000
		})
	</script>
	<c:remove var="delete_success" scope="session" />
</c:if>

<%@ include file="/WEB-INF/app/includes/layout-part2.jsp"%>