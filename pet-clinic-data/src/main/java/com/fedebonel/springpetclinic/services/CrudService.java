package com.fedebonel.springpetclinic.services;

import java.util.Set;

/**
 * Service that abstracts all CRUD operations against some data storage
 * @param <T> Type of objects to store
 * @param <ID> Type of object's id
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
