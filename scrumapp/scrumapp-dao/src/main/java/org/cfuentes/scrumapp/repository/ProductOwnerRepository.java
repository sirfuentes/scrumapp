package org.cfuentes.scrumapp.repository;

import org.cfuentes.scrumapp.dao.Dao;
import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.ProductOwner;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOwnerRepository extends Dao<ProductOwner, Long> {

}
