package org.cfuentes.scrumapp.service.api;

import java.util.List;

import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.service.commons.CrudOperations;

public interface ProyectoService extends CrudOperations<Proyecto, Long> {

	Boolean existsByCodigo(String codigo);

	List<Proyecto> findProyectosInvolucrado(Long idMiembro);

}
