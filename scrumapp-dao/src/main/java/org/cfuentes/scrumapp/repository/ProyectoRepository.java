package org.cfuentes.scrumapp.repository;

import java.util.List;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Proyecto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends Dao<Proyecto, Long> {

	Boolean existsByCodigo(String codigo);

	@Query("SELECT p FROM Proyecto p JOIN p.developers dev WHERE p.productOwner=:idMiembro")
	List<Proyecto> findProyectosInvolucrado(Long idMiembro);

}
