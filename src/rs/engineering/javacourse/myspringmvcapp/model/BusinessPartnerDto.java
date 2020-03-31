package rs.engineering.javacourse.myspringmvcapp.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class BusinessPartnerDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Can't  be empty.")
	private String identificationNumber;// mb

	private String name;
	private AddressDto addressDto;
	private boolean taxPayer;// is por.
	private String taxNumber;// pib

	public BusinessPartnerDto() {
		addressDto = new AddressDto();
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public boolean isTaxPayer() {
		return taxPayer;
	}

	public void setTaxPayer(boolean taxPayer) {
		this.taxPayer = taxPayer;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	@Override
	public String toString() {
		return "BusinessPartnerDto [identificationNumber=" + identificationNumber + ", name=" + name + ", addressDto="
				+ addressDto + ", taxPayer=" + taxPayer + ", taxNumber=" + taxNumber + "]";
	}

}
