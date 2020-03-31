package rs.engineering.javacourse.myspringmvcapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import rs.engineering.javacourse.myspringmvcapp.exception.MyValidationException;
import rs.engineering.javacourse.myspringmvcapp.model.BusinessPartnerDto;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.service.BusinessPartnerService;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;
import rs.engineering.javacourse.myspringmvcapp.validator.BusinessPartnerDtoValidator;

@Controller
@RequestMapping(value = "/businessPartner")
@SessionAttributes(value = "businessPartnerDto")
public class BusinessPartnerController {
	private final CityService cityService;
	private final BusinessPartnerService businessPartnerService;

	@Autowired
	BusinessPartnerController(CityService cityService, BusinessPartnerService businessPartnerService) {
		this.cityService = cityService;
		this.businessPartnerService = businessPartnerService;
	}

	@GetMapping
	public String home() {
		System.out.println("========== BusinessPartnerController: home()  ==========");
		return "businessPartner/home";
	}

	@GetMapping(value = "add")
	public ModelAndView add() {
		System.out.println("========== BusinessPartnerController: add()   ==============");

		ModelAndView modelAndView = new ModelAndView("businessPartner/add");
		// modelAndView.addObject("businessPartnerDto", new BusinessPartnerDto());
		// modelAndView.addObject("cities", getAllCities());
		return modelAndView;
	}

	@ModelAttribute(name = "businessPartnerDto")
	private BusinessPartnerDto getBusinessPartnerDto() {
		System.out.println("=====BusinessPartnerController: getBusinessPartnerDto() ========");
		BusinessPartnerDto businessPartnerDto = new BusinessPartnerDto();
		businessPartnerDto.setName("--");
		businessPartnerDto.setTaxPayer(false);
		return businessPartnerDto;
	}

	@ModelAttribute(name = "cities")
	private List<CityDto> getAllCities() {
		System.out.println("============= BusinessPartnerController: getAllCities() ============");

		return cityService.getAll();
	}

	@PostMapping(value = "confirm")
	public ModelAndView confirm(
			@Valid @ModelAttribute(name = "businessPartnerDto") BusinessPartnerDto businessPartnerDto, Errors errors) {

		System.out.println("============= BusinessPartnerController: confirm() =================");
		System.out.println(businessPartnerDto);

		ModelAndView modelAndView = new ModelAndView();
		if (errors.hasErrors()) {
			modelAndView.setViewName("businessPartner/add");
		} else {
			modelAndView.setViewName("businessPartner/add_confirm");
		}

		return modelAndView;
	}

	@PostMapping(value = "save")
	public String save(@ModelAttribute(name = "businessPartnerDto") BusinessPartnerDto businessPartnerDto,
			@RequestParam(name = "action") String action, SessionStatus sessionStatus) throws MyValidationException {

		System.out.println("============= BusinessPartnerController: save() =================");
		System.out.println(businessPartnerDto);

		if (action.equalsIgnoreCase("save")) {
			businessPartnerService.save(businessPartnerDto);
			sessionStatus.setComplete();
		}
		if (action.equalsIgnoreCase("cancel")) {
			sessionStatus.setComplete();
		}
		if (action.equalsIgnoreCase("change")) {

		}

		return "redirect:/businessPartner/add";
	}

	@ExceptionHandler(MyValidationException.class)
	public ModelAndView exceptionHandler(MyValidationException validationException) {
		System.out.println("---@ExceptionHandler exception ocured: MyValidationException===========");
		ModelAndView modelAndView = new ModelAndView("businessPartner/add");
		modelAndView.addObject("errorMessage", validationException.getMessage());
		modelAndView.addObject("businessPartnerDto", getBusinessPartnerDto());
		modelAndView.addObject("cities", getAllCities());
		return modelAndView;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new BusinessPartnerDtoValidator());
	}
}
