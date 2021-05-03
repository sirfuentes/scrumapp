package org.cfuentes.scrumapp.service.api;

import org.cfuentes.scrumapp.entity.ProductOwner;
import org.cfuentes.scrumapp.service.commons.CrudOperations;

public interface ProductOwnerService extends CrudOperations<ProductOwner, Long> {

	void insertProductOwner(Long id);
}
