package org.cfuentes.scrumapp.service.api;

import org.cfuentes.scrumapp.entity.ScrumMaster;
import org.cfuentes.scrumapp.service.commons.CrudOperations;

public interface ScrumMasterService extends CrudOperations<ScrumMaster, Long> {

	void insertScrumMaster(Long id);
}
