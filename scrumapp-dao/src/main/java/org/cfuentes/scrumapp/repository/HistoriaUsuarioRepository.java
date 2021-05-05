package org.cfuentes.scrumapp.repository;

import java.util.List;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaUsuarioRepository extends Dao<HistoriaUsuario, Long> {
	
	@Query("SELECT h FROM HistoriaUsuario h")
	List<HistoriaUsuario> findBySprintAndEstado(Long sprint, String estado);
	
	@Query("SELECT h FROM HistoriaUsuario h WHERE h.proyecto.idProyecto=:idProyecto ORDER BY h.prioridad")
	List<HistoriaUsuario> findHistoriaByProyecto(Long idProyecto);
	
	@Query("SELECT MAX(h.prioridad) FROM HistoriaUsuario h WHERE h.proyecto.idProyecto=:idProyecto")
	Integer siguientePrioridad(Long idProyecto);

	@Query("SELECT h FROM HistoriaUsuario h WHERE h.proyecto.idProyecto=:idProyecto AND h.estado=:estado")
	List<HistoriaUsuario> findByProyectoAndEstado(Long idProyecto, String estado);
	
}
