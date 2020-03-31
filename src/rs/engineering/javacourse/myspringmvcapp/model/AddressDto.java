package rs.engineering.javacourse.myspringmvcapp.model;

import java.io.Serializable;

public class AddressDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String street;
	private String streetNumber;
	private CityDto cityDto;
	
	public AddressDto() {
		cityDto = new CityDto();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public CityDto getCityDto() {
		return cityDto;
	}

	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}

	@Override
	public String toString() {
		return "AddressDto [street=" + street + ", streetNumber=" + streetNumber + ", cityDto=" + cityDto + "]";
	}

	
	
}
