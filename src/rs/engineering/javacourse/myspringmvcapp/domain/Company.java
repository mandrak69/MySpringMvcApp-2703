package rs.engineering.javacourse.myspringmvcapp.domain;

import java.io.Serializable;

public class Company  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String address;
	private String number;
	private City city;

	public Company() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", number=" + number + ", city=" + city + "]";
	}

}
