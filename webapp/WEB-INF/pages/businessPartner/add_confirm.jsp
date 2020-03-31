<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post" action="/MySpringMvcApp/businessPartner/save"
	modelAttribute="businessPartnerDto">
	<fieldset>
		<legend>Register new bussiness partner</legend>
		<table>
			<tr>
				<td><form:label path="identificationNumber">Identification number</form:label></td>
				<td><form:input path="identificationNumber" disabled="true" /></td>
				<td><form:errors path="identificationNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" disabled="true" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<fieldset>
						<legend>Adress</legend>
						<table>
							<tr>
								<td><form:label path="addressDto.street">Street</form:label></td>
								<td><form:input path="addressDto.street" disabled="true" /></td>
							</tr>
							<tr>
								<td><form:label path="addressDto.streetNumber">Street number</form:label></td>
								<td><form:input path="addressDto.streetNumber"
										disabled="true" /></td>
							</tr>
							<tr>
								<td colspan="2">
									<fieldset>
										<legend>City</legend>
										<table>
											<tr>
												<td><form:label path="addressDto.cityDto">City</form:label></td>
												<td><form:select path="addressDto.cityDto"
														disabled="true">
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
				<td><form:checkbox path="taxPayer" disabled="true" /></td>
				<td><form:errors path="taxPayer" /></td>
			</tr>

			<tr>
				<td><form:label path="taxNumber">Tax number</form:label></td>
				<td><form:input path="taxNumber" disabled="true" /></td>
				<td><form:errors path="taxNumber" /></td>
			</tr>

			<tr>
				<td><button id="cancel" name="action" value="cancel">Cancel</button></td>
				<td><button id="change" name="action" value="change">Change</button></td>
				<td><button id="save" name="action" value="save">Save</button></td>
			</tr>
		</table>
	</fieldset>
</form:form>