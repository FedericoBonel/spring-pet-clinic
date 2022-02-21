package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Pet;
import com.fedebonel.springpetclinic.services.CrudService;

import java.util.Set;


/**
 * Implementation of the map service for pets
 */
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
