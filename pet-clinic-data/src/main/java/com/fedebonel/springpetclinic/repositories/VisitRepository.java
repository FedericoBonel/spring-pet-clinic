package com.fedebonel.springpetclinic.repositories;

import com.fedebonel.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to access to the visits table
 */
@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
