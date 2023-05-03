<%@ include file="/WEB-INF/app/includes/layout-part1.jsp"%>

<div class="pd-20 card-box mb-30">
	<div class="clearfix">
		<div class="pull-left">
			<h4 class="text-blue h4">Ajouter Un Module</h4>
			<p class="mb-30"></p>
		</div>
		<div class="pull-right">
		</div>
	</div>
	<form action="../admin/ajoutermodule.asp" method="POST">
		<div class="form-group">
			<label>Nom Module </label> <input class="form-control ${empty error_nom ? '' : 'form-control-danger' }" type="text" placeholder="Nom Module" name="nom" value="${old_nom }">
			<c:if test="${not empty error_nom }">
				<div class="form-control-feedback text-danger mt-1 ml-1">${error_nom }</div>
				<c:remove var="error_nom" scope="session" />
			</c:if>
			<c:remove var="old_nom" scope="session" />
		</div>
		<div class="form-group">
			<label>Filiere</label> <select class="custom-select2 form-control ${empty error_filiere ? '' : 'form-control-danger' }" name="idfiliere" style="width: 100%; height: 38px;">
				<c:forEach items="${filieres }" var="filiere">
					<option value="${filiere.id }">${filiere.nom }</option>
				</c:forEach>
			</select>
			<c:if test="${not empty error_filiere }">
				<div class="form-control-feedback text-danger mt-1 ml-1">${error_filiere }</div>
				<c:remove var="error_filiere" scope="session" />
			</c:if>
		</div>
		<div class="form-group">
			<label>Description Module </label>
			<textarea class="form-control ${empty error_description ? '' : 'form-control-danger' }" name="description">${old_description }</textarea>
			<c:remove var="old_description" scope="session" />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Ajouter</button>
		</div>
	</form>
</div>

<%@ include file="/WEB-INF/app/includes/layout-part2.jsp"%>