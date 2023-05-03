<%@ include file="/WEB-INF/app/includes/layout-part1.jsp"%>

<div class="pd-20 card-box mb-30">
	<div class="clearfix">
		<div class="pull-left">
			<h4 class="text-blue h4">Modifier La Filiere</h4>
			<p class="mb-30"></p>
		</div>
		<div class="pull-right">
		</div>
	</div>
	<form action="../admin/modifierfiliere.asp?idfiliere=${filiere.id }" method="POST">
		<div class="form-group">
			<label>Nom Filiere </label> <input class="form-control ${empty error_nom ? '' : 'form-control-danger' }" type="text" placeholder="Nom Filiere" name="nom" value="${filiere.nom }">
			<c:if test="${not empty error_nom }">
				<div class="form-control-feedback text-danger mt-1 ml-1">${error_nom }</div>
				<c:remove var="error_nom" scope="session" />
			</c:if>
		</div>
		<div class="form-group">
			<label>Description Filiere </label>
			<textarea class="form-control${empty error_description ? '' : 'form-control-danger' }" name="description">${filiere.description }</textarea>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Modifier</button>
		</div>
	</form>
</div>

<%@ include file="/WEB-INF/app/includes/layout-part2.jsp"%>