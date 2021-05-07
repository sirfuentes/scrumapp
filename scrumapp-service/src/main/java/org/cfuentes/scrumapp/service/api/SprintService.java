package org.cfuentes.scrumapp.service.api;

import java.util.List;

import org.cfuentes.scrumapp.entity.Sprint;
import org.cfuentes.scrumapp.service.commons.CrudOperations;

public interface SprintService extends CrudOperations<Sprint, Long> {

	List<Sprint> findByProyecto(Long idProyecto);
	
	Sprint findLastByProyecto(Long idProyecto);


}
