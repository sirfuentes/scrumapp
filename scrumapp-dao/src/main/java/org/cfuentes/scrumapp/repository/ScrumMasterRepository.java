package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.ScrumMaster;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrumMasterRepository extends Dao<ScrumMaster, Long> {

	@Modifying
	@Query(value = "insert into SCRUM_MASTER (ID_SCRUM_MASTER) values (?1)", nativeQuery = true)
	void insertScrumMaster(Long id);
}
