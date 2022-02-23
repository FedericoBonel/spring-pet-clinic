package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Vet;
import com.fedebonel.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * Implementation of the map service for vets of the clinic
 */
@Service
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {

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
        return super.save(object);
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
