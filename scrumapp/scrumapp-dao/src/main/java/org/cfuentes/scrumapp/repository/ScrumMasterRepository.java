package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.ScrumMaster;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrumMasterRepository extends Dao<ScrumMaster, Long> {

}
