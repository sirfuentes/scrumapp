package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Sprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends Dao<Sprint, Long> {

	@Query("SELECT s FROM Sprint s WHERE s.proyecto.idProyecto=:idProyecto ORDER BY s.idSprint DESC")
	Sprint findByProyecto(Long idProyecto);

}
