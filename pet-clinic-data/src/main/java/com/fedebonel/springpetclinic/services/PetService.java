package com.fedebonel.springpetclinic.services;

import com.fedebonel.springpetclinic.model.Pet;

/**
 * A Service that abstracts a repository, this way we avoid using specific implementations in uses
 */
public interface PetService extends CrudService<Pet, Long>{

}
