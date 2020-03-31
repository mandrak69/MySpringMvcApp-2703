package rs.engineering.javacourse.myspringmvcapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import rs.engineering.javacourse.myspringmvcapp.model.BusinessPartnerDto;

public class BusinessPartnerDtoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BusinessPartnerDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BusinessPartnerDto businessPartnerDto = (BusinessPartnerDto) target;

		System.out.println("==========  BusinessPartnerDtoValidator ===============");
		System.out.println(businessPartnerDto);

		if (businessPartnerDto != null && businessPartnerDto.isTaxPayer()) {
			// mora da ima pib
			if (businessPartnerDto.getTaxNumber().isEmpty()) {
				errors.rejectValue("taxNumber", "businessPartner.taxNumber",
						"You must have taxNumber for tax payer business partner!");
			}
		}

	}

}
