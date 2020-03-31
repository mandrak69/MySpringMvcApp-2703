package rs.engineering.javacourse.myspringmvcapp.formatter;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

public class CityDtoFormatter implements Formatter<CityDto> {
	private final CityService cityService;

	@Autowired
	public CityDtoFormatter(CityService cityService) {
		System.out.println("=======CityDtoFormatter: constructor============================");
		this.cityService = cityService;
	}

	@Override
	public String print(CityDto cityDto, Locale locale) {
		System.out.println("=======CityDtoFormatter: print===================================");
		System.out.println(cityDto);
		return cityDto.toString();
	}

	@Override
	public CityDto parse(String city, Locale locale) {
		System.out.println("=======CityDtoFormatter: parse===========================");
		System.out.println(city);

		Long number = Long.parseLong(city);
		System.out.println(number);
		CityDto cityDto = cityService.findById(number);
		return cityDto;
	}

}
