package org.cfuentes.scrumapp.service.api;

import java.util.List;

import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.service.commons.CrudOperations;

public interface HistoriaUsuarioService extends CrudOperations<HistoriaUsuario, Long> {

	List<HistoriaUsuario> findBySprintAndEstado(Long sprint, String estado);
	
	List<HistoriaUsuario> findHistoriaByProyecto(Long idProyecto);

	Integer siguientePrioridad(Long idProyecto);

	List<HistoriaUsuario> findByProyectoAndEstado(Long idProyecto, String estado);

	HistoriaUsuario findMiembroByNombre(String value);

	HistoriaUsuario findHistoriaUsuarioByCodigo(String codigo);
}
