package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import org.cfuentes.scrumapp.entity.EstadoTarea;
import org.cfuentes.scrumapp.repository.EstadoTareaRepository;
import org.cfuentes.scrumapp.service.api.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoTareaServiceImpl implements EstadoTareaService{

	@Autowired
	EstadoTareaRepository estadoTareaRepository;
	
	@Override
	public EstadoTarea findById(Long id) {
		return estadoTareaRepository.findById(id).orElse(null);
	}

	@Override
	public List<EstadoTarea> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(EstadoTarea entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EstadoTarea saveOrUpdate(EstadoTarea entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(EstadoTarea entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EstadoTarea entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EstadoTarea findEstadoTareaByCodigo(String codigo) {
		return estadoTareaRepository.findEstadoTareaByCodigo(codigo);
	}

	@Override
	public EstadoTarea findEstadoTareaByNombre(String nombre) {
		return estadoTareaRepository.findEstadoTareaByNombre(nombre);
	}

}
