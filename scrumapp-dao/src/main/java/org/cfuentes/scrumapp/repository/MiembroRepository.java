package org.cfuentes.scrumapp.repository;

import java.util.List;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Miembro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MiembroRepository extends Dao<Miembro, Long> {
    Miembro findMiembroByEmail(String email);

	Boolean existsByEmail(String email);
	
//	@Query("SELECT m FROM Miembro m JOIN m.proyectosAsDev proyecto JOIN Proyecto.developers dev WHERE proyecto.idProyecto=:idProyecto")
//	List<Miembro> findMiembroByProyecto(Long idProyecto);
}
