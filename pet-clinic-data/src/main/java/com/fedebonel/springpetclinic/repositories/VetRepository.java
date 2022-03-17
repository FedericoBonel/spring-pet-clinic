package com.fedebonel.springpetclinic.repositories;

import com.fedebonel.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to access to the vets table
 */
@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
