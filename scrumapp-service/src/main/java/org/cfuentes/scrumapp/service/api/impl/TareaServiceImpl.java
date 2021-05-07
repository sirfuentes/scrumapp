package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import org.cfuentes.scrumapp.entity.Tarea;
import org.cfuentes.scrumapp.repository.TareaRepository;
import org.cfuentes.scrumapp.service.api.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaServiceImpl implements TareaService{

	@Autowired
	TareaRepository tareaRepository;
	
	@Override
	public Tarea findById(Long id) {
		return tareaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Tarea> findAll() {
		return (List<Tarea>) tareaRepository.findAll();
	}

	@Override
	public boolean exists(Tarea entity) {
		return tareaRepository.existsById(entity.getIdTarea());
	}

	@Override
	public boolean existsById(Long id) {
		return tareaRepository.existsById(id);
	}

	@Override
	public Tarea saveOrUpdate(Tarea entity) {
		return tareaRepository.save(entity);
	}

	@Override
	public void validate(Tarea entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tarea entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tarea> findBySprintAndEstado(Long idSprint, String estado) {
		return tareaRepository.findBySprintAndEstado(idSprint, estado);
	}

}
