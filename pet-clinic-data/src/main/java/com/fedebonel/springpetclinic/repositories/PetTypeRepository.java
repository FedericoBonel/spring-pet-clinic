package com.fedebonel.springpetclinic.repositories;

import com.fedebonel.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to access to the pet types table
 */
@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
