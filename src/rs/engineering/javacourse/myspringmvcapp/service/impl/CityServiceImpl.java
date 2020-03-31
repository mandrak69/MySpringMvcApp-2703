package rs.engineering.javacourse.myspringmvcapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.repository.CityRepository;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Qualifier(value = "cityJpaRepository")
	@Autowired
	private CityRepository<CityEntity> cityRepository;

//	public CityServiceImpl(CityRepository cityRepository) {
//		this.cityRepository = cityRepository;
//	}

	@Override
	public void save(CityDto cityDto) {
		CityEntity city = new CityEntity(cityDto.getNumber(), cityDto.getName());
		cityRepository.save(city);
	}

	@Override
	public List<CityDto> getAll() {
		List<CityDto> cities = new ArrayList<CityDto>();
		List<CityEntity> cityiesEntity = cityRepository.findAll();
		for (CityEntity cityEntity : cityiesEntity) {
			cities.add(new CityDto(cityEntity.getNumber(), cityEntity.getName()));
		}
		return cities;
	}

	@Override
	public CityDto findById(Long id) {
		CityEntity cityEntity = cityRepository.findById(id);
		CityDto cityDto = new CityDto(cityEntity.getNumber(), cityEntity.getName());
		return cityDto;
	}

}
