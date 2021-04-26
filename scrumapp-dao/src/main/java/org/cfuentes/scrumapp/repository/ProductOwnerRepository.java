package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.ProductOwner;
import org.springframework.data.jpa.repository.Query;

public interface ProductOwnerRepository extends Dao<ProductOwner, Long> {
	
	ProductOwner findProductOwnerByEmail(String email);
}
