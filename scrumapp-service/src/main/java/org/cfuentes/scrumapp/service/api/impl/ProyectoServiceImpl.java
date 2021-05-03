package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.repository.ProyectoRepository;
import org.cfuentes.scrumapp.service.api.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoServiceImpl implements ProyectoService{

	@Autowired
	ProyectoRepository proyectoRepository;

	@Override
	public Proyecto findById(Long id) {
		return proyectoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Proyecto> findAll() {
		return (List<Proyecto>) proyectoRepository.findAll();
	}

	@Override
	public boolean exists(Proyecto entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Proyecto saveOrUpdate(Proyecto entity) {
		return proyectoRepository.save(entity);
	}

	@Override
	public void validate(Proyecto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Proyecto entity) {
		proyectoRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		proyectoRepository.deleteById(id);
		
	}
	
	

}
