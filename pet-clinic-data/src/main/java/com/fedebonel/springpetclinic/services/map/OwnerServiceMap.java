package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.services.CrudService;

import java.util.Set;

/**
 * Implementation of the map service for owners
 */
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
