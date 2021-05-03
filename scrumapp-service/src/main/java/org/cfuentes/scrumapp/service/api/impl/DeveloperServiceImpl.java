package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cfuentes.scrumapp.entity.Developer;
import org.cfuentes.scrumapp.repository.DeveloperRepository;
import org.cfuentes.scrumapp.service.api.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	DeveloperRepository developerRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Developer findById(Long id) {
		return developerRepository.findById(id).orElse(null);
	}

	@Override
	public List<Developer> findAll() {
		return (List<Developer>) developerRepository.findAll();
	}

	@Override
	public boolean exists(Developer entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Developer saveOrUpdate(Developer entity) {
		return developerRepository.save(entity);
	}

	@Override
	public void validate(Developer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Developer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	public void insertDeveloper(Long id) {
		//entityManager.createNativeQuery("insert into DEVELOPER (ID_DEVELOPER) values (?)").setParameter(1, id).executeUpdate();
		developerRepository.insertDeveloper(id);
	}

}
