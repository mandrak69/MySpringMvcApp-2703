package rs.engineering.javacourse.myspringmvcapp.service.impl;

import org.springframework.stereotype.Service;

import rs.engineering.javacourse.myspringmvcapp.exception.MyValidationException;
import rs.engineering.javacourse.myspringmvcapp.model.BusinessPartnerDto;
import rs.engineering.javacourse.myspringmvcapp.service.BusinessPartnerService;

@Service
public class BusinessPartnerServiceImpl implements BusinessPartnerService {

	@Override
	public void save(BusinessPartnerDto businessPartnerDto) throws MyValidationException {
		if (businessPartnerDto.getIdentificationNumber().equals("i1")) {
			throw new MyValidationException("Business partner already exist.");
		}
		if (businessPartnerDto.getIdentificationNumber().equals("null")) {
			throw new NullPointerException("Null pointer exception.");
		}
	}

}
