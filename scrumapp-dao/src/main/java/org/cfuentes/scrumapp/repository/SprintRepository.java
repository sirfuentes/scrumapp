package org.cfuentes.scrumapp.repository;

import java.util.List;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Sprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends Dao<Sprint, Long> {

	@Query("SELECT s FROM Sprint s WHERE s.proyecto.idProyecto=:idProyecto ORDER BY s.fechaInicio DESC")
	List<Sprint> findByProyectoOrderByFechaInicioDesc(Long idProyecto);
	
	@Query("SELECT s FROM Sprint s WHERE s.proyecto.idProyecto=:idProyecto ORDER BY s.fechaInicio")
	List<Sprint> findByProyectoOrderByFechaInicioAsc(Long idProyecto);

	@Query("SELECT s FROM Sprint s WHERE s.proyecto.idProyecto=:idProyecto AND CURRENT_DATE between s.fechaInicio and s.fechaFin")
	Sprint findActualByProyecto(Long idProyecto);


}
