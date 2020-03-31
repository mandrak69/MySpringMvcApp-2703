package rs.engineering.javacourse.myspringmvcapp.service;

import rs.engineering.javacourse.myspringmvcapp.exception.MyValidationException;
import rs.engineering.javacourse.myspringmvcapp.model.BusinessPartnerDto;

public interface BusinessPartnerService {
	void save(BusinessPartnerDto businessPartnerDto) throws MyValidationException;
}
