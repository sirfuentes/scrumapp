package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.ProductOwner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOwnerRepository extends Dao<ProductOwner, Long> {
	
	@Modifying
	@Query(value = "insert into PRODUCT_OWNER (ID_PRODUCT_OWNER) values (?1)", nativeQuery = true)
	void insertProductOwner(Long id);
}
