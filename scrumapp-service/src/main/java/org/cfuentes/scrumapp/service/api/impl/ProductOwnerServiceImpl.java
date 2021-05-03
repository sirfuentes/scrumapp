package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import org.cfuentes.scrumapp.entity.ProductOwner;
import org.cfuentes.scrumapp.repository.ProductOwnerRepository;
import org.cfuentes.scrumapp.service.api.ProductOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductOwnerServiceImpl implements ProductOwnerService{

	@Autowired
	ProductOwnerRepository productOwnerRepository;
	
	@Override
	public ProductOwner findById(Long id) {
		return productOwnerRepository.findById(id).orElse(null);
	}

	@Override
	public List<ProductOwner> findAll() {
		return (List<ProductOwner>) productOwnerRepository.findAll();
	}

	@Override
	public boolean exists(ProductOwner entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductOwner saveOrUpdate(ProductOwner entity) {
		return productOwnerRepository.save(entity);
	}

	@Override
	public void validate(ProductOwner entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductOwner entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void insertProductOwner(Long id) {
		productOwnerRepository.insertProductOwner(id);
	}
}
