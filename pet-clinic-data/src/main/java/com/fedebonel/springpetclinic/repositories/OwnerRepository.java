package com.fedebonel.springpetclinic.repositories;

import com.fedebonel.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to access to the owners table
 */
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
