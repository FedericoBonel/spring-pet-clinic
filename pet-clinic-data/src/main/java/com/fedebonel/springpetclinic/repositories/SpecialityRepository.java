package com.fedebonel.springpetclinic.repositories;


import com.fedebonel.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to access to the specialties table
 */
@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
