package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Developer;
import org.cfuentes.scrumapp.entity.Miembro;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends Dao<Developer, Long> {

}
