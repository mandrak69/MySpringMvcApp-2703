package rs.engineering.javacourse.myspringmvcapp.service;

import java.util.List;

import rs.engineering.javacourse.myspringmvcapp.model.CityDto;

public interface CityService {
	void save(CityDto cityDto);

	List<CityDto> getAll();

	CityDto findById(Long id);
}
