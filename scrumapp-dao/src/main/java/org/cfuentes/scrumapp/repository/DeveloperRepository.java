package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Developer;
import org.cfuentes.scrumapp.entity.Miembro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends Dao<Developer, Long> {
	
	@Modifying
	@Query(value = "insert into DEVELOPER (ID_DEVELOPER) values (?1)", nativeQuery = true)
	void insertDeveloper(Long id);
}
