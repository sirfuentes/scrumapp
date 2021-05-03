package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import org.cfuentes.scrumapp.entity.ScrumMaster;
import org.cfuentes.scrumapp.repository.ScrumMasterRepository;
import org.cfuentes.scrumapp.service.api.ScrumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScrumMasterServiceImpl implements ScrumMasterService{

	@Autowired
	ScrumMasterRepository scrumMasterRepository;
	
	@Override
	public ScrumMaster findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScrumMaster> findAll() {
		return findAll();
	}

	@Override
	public boolean exists(ScrumMaster entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ScrumMaster saveOrUpdate(ScrumMaster entity) {
		return saveOrUpdate(entity);
	}

	@Override
	public void validate(ScrumMaster entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ScrumMaster entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	public void insertScrumMaster(Long id) {
		scrumMasterRepository.insertScrumMaster(id);
	}
}
