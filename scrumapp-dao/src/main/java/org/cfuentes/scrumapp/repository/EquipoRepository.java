package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Equipo;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends Dao<Equipo, Long> {
}
