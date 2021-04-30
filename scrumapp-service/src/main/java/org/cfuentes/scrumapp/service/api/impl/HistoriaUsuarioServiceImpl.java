package org.cfuentes.scrumapp.service.api.impl;

import java.util.List;

import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.cfuentes.scrumapp.repository.HistoriaUsuarioRepository;
import org.cfuentes.scrumapp.service.api.HistoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriaUsuarioServiceImpl implements HistoriaUsuarioService {

	@Autowired
	HistoriaUsuarioRepository historiaUsuarioRepository;
	
	@Override
	public HistoriaUsuario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistoriaUsuario> findAll() {
		return (List<HistoriaUsuario>) historiaUsuarioRepository.findAll();
	}

	@Override
	public boolean exists(HistoriaUsuario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HistoriaUsuario saveOrUpdate(HistoriaUsuario entity) {
		return historiaUsuarioRepository.save(entity);
	}

	@Override
	public void validate(HistoriaUsuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HistoriaUsuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HistoriaUsuario> findBySprintAndEstado(Long sprint, String estado) {
		return historiaUsuarioRepository.findBySprintAndEstado(sprint, estado);
	}

}
