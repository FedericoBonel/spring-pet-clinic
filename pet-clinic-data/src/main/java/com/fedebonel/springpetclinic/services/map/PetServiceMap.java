package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Pet;
import com.fedebonel.springpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * Implementation of the map service for pets
 */
@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService {

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
        return super.save(object);
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
