package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.entity.CityEntity;
import rs.engineering.javacourse.myspringmvcapp.repository.CityRepository;

@Repository(value = "cityJpaRepository")
@Transactional(propagation = Propagation.MANDATORY)
public class CityJpaRepository implements CityRepository<CityEntity> {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save(CityEntity city) {
		System.out.println("save city from CityJpaRepository");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityEntity> findAll() {
		return entityManager.createQuery("SELECT c FROM CityEntity c").getResultList();
	}

	@Override
	public CityEntity findById(Long key) {
		System.out.println("================findById=========================");
		System.out.println("CityJpaRepository: " + key);
		return entityManager.find(CityEntity.class, key);
	}

}
