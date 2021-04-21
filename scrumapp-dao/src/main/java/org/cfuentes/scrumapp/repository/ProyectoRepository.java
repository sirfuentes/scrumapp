package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Proyecto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends Dao<Proyecto, Long> {

}
