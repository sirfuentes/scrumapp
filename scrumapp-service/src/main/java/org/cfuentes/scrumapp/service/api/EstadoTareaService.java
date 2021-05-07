package org.cfuentes.scrumapp.service.api;

import org.cfuentes.scrumapp.entity.EstadoTarea;
import org.cfuentes.scrumapp.service.commons.CrudOperations;

public interface EstadoTareaService extends CrudOperations<EstadoTarea, Long> {

	EstadoTarea findEstadoTareaByCodigo(String codigo);

	EstadoTarea findEstadoTareaByNombre(String nombre);

}
