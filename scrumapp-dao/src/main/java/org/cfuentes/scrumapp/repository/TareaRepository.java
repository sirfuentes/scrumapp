package org.cfuentes.scrumapp.repository;

import java.util.List;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Tarea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends Dao<Tarea, Long> {

	@Query("SELECT t FROM Tarea t WHERE t.sprint.idSprint=:idSprint AND t.estadoTarea.codigo=:estado")
	List<Tarea> findBySprintAndEstado(Long idSprint, String estado);

}
