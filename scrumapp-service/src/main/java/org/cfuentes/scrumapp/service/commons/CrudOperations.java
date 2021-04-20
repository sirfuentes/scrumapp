package org.cfuentes.scrumapp.service.commons;

import java.io.Serializable;
import java.util.List;

public interface CrudOperations<T, ID> extends Serializable {

    T findById(ID id);

    List<T> findAll();

    boolean exists(T entity);

    boolean existsById(ID id);

    T saveOrUpdate(T entity);

    void validate(T entity);

    void delete(T entity);

    void deleteById(ID id);
}
