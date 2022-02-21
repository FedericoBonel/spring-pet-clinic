package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Vet;
import com.fedebonel.springpetclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
