package org.cfuentes.scrumapp.service.api.impl;

import org.cfuentes.scrumapp.entity.Equipo;
import org.cfuentes.scrumapp.repository.EquipoRepository;
import org.cfuentes.scrumapp.service.api.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {
	
    @Autowired
    private EquipoRepository equipoRepository;


    @Override
    public Equipo findById(Long id) {
        return equipoRepository.findById(id).get();
    }

    @Override
    public List<Equipo> findAll() {
        return null;
    }

    @Override
    public boolean exists(Equipo entity) {
        return false;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Equipo saveOrUpdate(Equipo entity) {
        return null;
    }

    @Override
    public void validate(Equipo entity) {

    }

    @Override
    public void delete(Equipo entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
