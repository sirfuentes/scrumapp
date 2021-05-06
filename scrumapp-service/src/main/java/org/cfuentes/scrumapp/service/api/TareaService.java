package org.cfuentes.scrumapp.service.api;

import java.util.List;

import org.cfuentes.scrumapp.entity.Tarea;
import org.cfuentes.scrumapp.service.commons.CrudOperations;

public interface TareaService extends CrudOperations<Tarea, Long> {

	List<Tarea> findBySprintAndEstado(Long idSprint, String estado);

}
