package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import org.cfuentes.scrumapp.entity.Sprint;
import org.cfuentes.scrumapp.repository.SprintRepository;
import org.cfuentes.scrumapp.service.api.ProyectoService;
import org.cfuentes.scrumapp.service.api.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	SprintRepository sprintRepository;
	
	@Override
	public Sprint findById(Long id) {
		return sprintRepository.findById(id).orElse(null);
	}

	@Override
	public List<Sprint> findAll() {
		return (List<Sprint>) sprintRepository.findAll();
	}

	@Override
	public boolean exists(Sprint entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sprint saveOrUpdate(Sprint entity) {
		return sprintRepository.save(entity);
	}

	@Override
	public void validate(Sprint entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sprint entity) {
		sprintRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sprint> findByProyecto(Long idProyecto) {
		return sprintRepository.findByProyectoOrderByFechaInicioAsc(idProyecto);
	}
	
	@Override
	public Sprint findLastByProyecto(Long idProyecto) {
		Sprint s = sprintRepository.findByProyectoOrderByFechaInicioDesc(idProyecto).get(0);
		return s;
	}

	@Override
	public Sprint findActualByProyecto(Long idProyecto) {
		Sprint actual = sprintRepository.findActualByProyecto(idProyecto).get(0);
		if (actual != null) {
			return actual;
		}
		else {
			return findAll().get(0);
		}
		
	}

}
