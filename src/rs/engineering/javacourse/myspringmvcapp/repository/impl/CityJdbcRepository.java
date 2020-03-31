package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.repository.CityRepository;

@Repository(value = "cityJdbcRepository")
public class CityJdbcRepository implements CityRepository<City> {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CityJdbcRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(City city) {
		String query = "INSERT INTO city VALUES (?,?)";
		jdbcTemplate.update(query, city.getNumber(), city.getName());
	}

	@Override
	public List<City> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<City>();
	}

	@Override
	public City findById(Long key) {
		return null;
	}

}
