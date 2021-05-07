package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.EstadoTarea;
import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoTareaRepository extends Dao<EstadoTarea, Long> {

	EstadoTarea findEstadoTareaByCodigo(String codigo);

	EstadoTarea findEstadoTareaByNombre(String nombre);

}
