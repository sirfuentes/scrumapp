package org.cfuentes.scrumapp.service.api;

import org.cfuentes.scrumapp.entity.Sprint;
import org.cfuentes.scrumapp.service.commons.CrudOperations;

public interface SprintService extends CrudOperations<Sprint, Long> {

	Sprint findByProyecto(Long idProyecto);

}
