package com.fedebonel.springpetclinic.services;

import com.fedebonel.springpetclinic.model.Pet;

import java.util.Set;

/**
 * A Service that abstracts a repository, this way we avoid using specific implementations in uses
 */
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
