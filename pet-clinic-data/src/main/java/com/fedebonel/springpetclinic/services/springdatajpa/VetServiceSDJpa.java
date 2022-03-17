package com.fedebonel.springpetclinic.services.springdatajpa;

import com.fedebonel.springpetclinic.model.Vet;
import com.fedebonel.springpetclinic.repositories.VetRepository;
import com.fedebonel.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetServiceSDJpa implements VetService {

    private final VetRepository vetRepository;

    public VetServiceSDJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        HashSet<Vet> result = new HashSet<>();
        vetRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
