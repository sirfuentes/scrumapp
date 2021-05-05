package org.cfuentes.scrumapp.service.api.impl;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.repository.MiembroRepository;
import org.cfuentes.scrumapp.service.api.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MiembroServiceImpl implements MiembroService {

	@Autowired
	MiembroRepository miembroRepository;

    @Override
    public Miembro findById(Long aLong) {
        return null;
    }

    @Override
    public List<Miembro> findAll() {
    	return (List<Miembro>) miembroRepository.findAll();
    }

    @Override
    public boolean exists(Miembro entity) {
        return false;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Miembro saveOrUpdate(Miembro entity) {
    	return miembroRepository.save(entity);
    }

    @Override
    public void validate(Miembro entity) {

    }

    @Override
    public void delete(Miembro entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
    
    @Override
	public Miembro findMiembroByEmail(String email) {
		return miembroRepository.findMiembroByEmail(email);
	}

	@Override
	public Boolean existsByEmail(String email) {
		return miembroRepository.existsByEmail(email);
	}


}
