package org.cfuentes.scrumapp.repository;

import java.util.List;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaUsuarioRepository extends Dao<HistoriaUsuario, Long> {
	
	@Query("SELECT h FROM HistoriaUsuario h WHERE h.sprint.idSprint = ?1 and h.estado = ?2")
	List<HistoriaUsuario> findBySprintAndEstado(Long sprint, String estado);
}