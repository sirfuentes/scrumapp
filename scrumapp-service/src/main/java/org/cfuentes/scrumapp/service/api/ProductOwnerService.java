package org.cfuentes.scrumapp.service.api;

import org.cfuentes.scrumapp.entity.ProductOwner;
import org.cfuentes.scrumapp.service.commons.CrudOperations;
import org.springframework.data.jpa.repository.Query;

public interface ProductOwnerService extends CrudOperations<ProductOwner, Long> {
	
	ProductOwner findProductOwnerByEmail(String email);
}
