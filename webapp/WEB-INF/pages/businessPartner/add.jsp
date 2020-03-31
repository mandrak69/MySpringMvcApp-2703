<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post"
	action="/MySpringMvcApp/businessPartner/confirm"
	modelAttribute="businessPartnerDto">
	<c:if test="${not empty errorMessage }">
		<div>${errorMessage}</div>
	</c:if>

	<fieldset>
		<legend>Register new bussiness partner</legend>
		<table>
			<tr>
				<td><form:label path="identificationNumber">Identification number</form:label></td>
				<td><form:input path="identificationNumber" /></td>
				<td><form:errors path="identificationNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<fieldset>
						<legend>Adress</legend>
						<table>
							<tr>
								<td><form:label path="addressDto.street">Street</form:label></td>
								<td><form:input path="addressDto.street" /></td>
							</tr>
							<tr>
								<td><form:label path="addressDto.streetNumber">Street number</form:label></td>
								<td><form:input path="addressDto.streetNumber" /></td>
							</tr>
							<tr>
								<td colspan="2">
									<fieldset>
										<legend>City</legend>
										<table>
											<tr>
												<td><form:label path="addressDto.cityDto">City</form:label></td>
												<td><form:select path="addressDto.cityDto">
														<form:options items="${cities}" itemValue="number"
															itemLabel="name" />
													</form:select></td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>

			<tr>
				<!-- da li je poreski obveznik ili ne -->
				<td><form:label path="taxPayer">Is it tax payer</form:label></td>
				<td><form:checkbox path="taxPayer" /></td>
				<td><form:errors path="taxPayer" /></td>
			</tr>

			<tr>
				<td><form:label path="taxNumber">Tax number</form:label></td>
				<td><form:input path="taxNumber" /></td>
				<td><form:errors path="taxNumber" /></td>
			</tr>

			<tr>
				<td>
					<button id="save">Save</button>
				</td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</fieldset>
</form:form>