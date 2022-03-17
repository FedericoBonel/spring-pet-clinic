package com.fedebonel.springpetclinic.repositories;

import com.fedebonel.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to access to the pets table
 */
@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
