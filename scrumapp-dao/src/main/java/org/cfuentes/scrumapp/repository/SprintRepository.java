package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Sprint;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends Dao<Sprint, Long> {

}
