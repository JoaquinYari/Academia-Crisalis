<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>

<div class="modal-body">
	<form>
		<div class="row mb-3">
			<label for="firsName" class="col-sm-2 col-form-label">First
				Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstName" name="firstName" required value="${person.firstName}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="lastName" class="col-sm-2 col-form-label">Last
				Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="lastName" name="lastName" required value="${person.lastName}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="dni" 
				class="col-sm-2 col-form-label ${person.errors.get('dni') != null ? 'is-invalid' : ''}">DNI</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="dni" name="dni" required value="${person.dni}">
			</div>
			<div class="invalid-feedback">
				<c:out value="${person.errors.get('dni'}"></c:out>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</div>