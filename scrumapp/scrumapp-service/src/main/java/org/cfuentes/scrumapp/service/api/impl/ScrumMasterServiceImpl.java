package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import org.cfuentes.scrumapp.entity.ScrumMaster;
import org.cfuentes.scrumapp.service.api.ScrumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrumMasterServiceImpl implements ScrumMasterService{

	@Autowired
	ScrumMasterService scrumMasterService;
	
	@Override
	public ScrumMaster findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScrumMaster> findAll() {
		return scrumMasterService.findAll();
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
		return scrumMasterService.saveOrUpdate(entity);
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

}
