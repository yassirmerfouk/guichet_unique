<%@ include file="/WEB-INF/app/includes/layout-part1.jsp"%>

<div class="pd-20 card-box mb-30">
	<div class="clearfix">
		<div class="pull-left">
			<h4 class="text-blue h4">Ajouter Une candidature</h4>
			<p class="mb-30"></p>
		</div>
		<div class="pull-right"></div>
	</div>
	<form action="../admin/modifiercandidature.asp?idcandidature=${candidature.id }" method="POST">
		<div class="form-group">
			<label>Nom Candidature </label> <input class="form-control ${empty error_nom ? '' : 'form-control-danger' }" type="text" placeholder="Nom Candidature" name="nom" value="${candidature.nom }">
			<c:if test="${not empty error_nom }">
				<div class="form-control-feedback text-danger mt-1 ml-1">${error_nom }</div>
				<c:remove var="error_nom" scope="session" />
			</c:if>
			<c:remove var="old_nom" scope="session" />
		</div>
		<div class="form-group">
			<label>Filiere</label> <select class="custom-select2 form-control ${empty error_filiere ? '' : 'form-control-danger' }" name="idfiliere" style="width: 100%; height: 38px;">
				<option value="${candidature.filiere.id }" selected>${candidature.filiere.nom }</option>
				<c:forEach items="${filieres }" var="filiere">
				<option value="${filiere.id }">${filiere.nom }</option>
				</c:forEach>
			</select>
			<c:if test="${not empty error_filiere }">
				<div class="form-control-feedback text-danger mt-1 ml-1">${error_filiere }</div>
				<c:remove var="error_filiere" scope="session" />
			</c:if>
		</div>
		<div class="row">
			<div class="form-group col-6">
				<label>Date Ouverture</label> <input class="form-control ${empty error_dateOuverture ? '' : 'form-control-danger' }" placeholder="Select Date" type="date" name="dateOuverture" value="${candidature.dateOuverture }" readonly>
				<c:if test="${not empty error_dateOuverture }">
					<div class="form-control-feedback text-danger mt-1 ml-1">${error_dateOuverture }</div>
					<c:remove var="error_dateOuverture" scope="session" />
				</c:if>
				<c:remove var="old_dateOuverture" scope="session" />
			</div>
			<div class="form-group col-6">
				<label>Date Limite</label> <input class="form-control ${empty error_dateLimite ? '' : 'form-control-danger' }" placeholder="Select Date" type="date" name="dateLimite" value="${candidature.dateLimite }">
				<c:if test="${not empty error_dateLimite }">
					<div class="form-control-feedback text-danger mt-1 ml-1">${error_dateLimite }</div>
					<c:remove var="error_dateLimite" scope="session" />
				</c:if>
				<c:remove var="old_dateLimite" scope="session" />
			</div>
		</div>
		<div class="form-group">
			<label>Date Concour</label> <input class="form-control ${empty error_dateConcour ? '' : 'form-control-danger' }" placeholder="Select Date" type="date" name="dateConcour" value="${candidature.dateConcour }">
			<c:if test="${not empty error_dateConcour }">
				<div class="form-control-feedback text-danger mt-1 ml-1">${error_dateConcour }</div>
				<c:remove var="error_dateConcour" scope="session" />
			</c:if>
			<c:remove var="old_dateConcour" scope="session" />
		</div>
		<div class="form-group">
			<label>Description Candidature</label>
			<textarea class="form-control ${empty error_description ? '' : 'form-control-danger' }" name="description">${candidature.description }</textarea>
			<c:remove var="old_description" scope="session" />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Modifier</button>
		</div>
	</form>
</div>

<%@ include file="/WEB-INF/app/includes/layout-part2.jsp"%>