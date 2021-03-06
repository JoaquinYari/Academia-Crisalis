<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>

<div class="modal-body">
	<form>
		<div class="row mb-3">
			<label for="companyName" class="col-sm-2 col-form-label">Company
				Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="companyName"
					name="companyName" required value="${company.companyName}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="cuit"
				class="col-sm-2 col-form-label ${company.errors.get('cuit') != null ? 'is-invalid' : ''}">CUIT</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="cuit" name="cuit"
					required value="${company.cuit}">
			</div>
			<div class="invalid-feedback">
				<c:out value="${company.errors.get('cuit'}"></c:out>
			</div>
		</div>
		<div class="row mb-3">
			<label for="startActivity" class="col-sm-2 col-form-label">Start
				of activity</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="startActivity"
					name="startActivity" required value="${company.startActivity">
			</div>
		</div>
	</form>
</div>