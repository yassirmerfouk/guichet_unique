<%@ include file="/WEB-INF/app/includes/layout-part1.jsp"%>

<!-- horizontal Basic Forms Start -->
<div class="pd-20 card-box mb-30">
	<div class="clearfix">
		<div class="pull-left">
			<h4 class="text-blue h4">Ajouter Une Filiere</h4>
			<p class="mb-30"></p>
		</div>
	</div>
	<form action="../admin/ajouterfiliere.asp" method="POST">
		<div class="form-group">
			<label>Nom Filiere </label> <input class="form-control ${empty error_nom ? '' : 'form-control-danger' }" type="text" placeholder="Nom Filiere" name="nom" value="${empty old_nom ? '' : old_nom }">
			<c:if test="${not empty error_nom }">
				<div class="form-control-feedback text-danger mt-1 ml-1">${error_nom }</div>
				<c:remove var="error_nom" scope="session" />
			</c:if>
			<c:remove var="old_nom" scope="session" />
		</div>
		<div class="form-group">
			<label>Description Filiere </label>
			<textarea class="form-control ${empty error_description ? '' : 'form-control-danger' }" name="description">${empty old_description ? '' : old_description }</textarea>
			<c:remove var="old_description" scope="session" />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</div>
	</form>
</div>
<!-- horizontal Basic Forms End -->

<%@ include file="/WEB-INF/app/includes/layout-part2.jsp"%>