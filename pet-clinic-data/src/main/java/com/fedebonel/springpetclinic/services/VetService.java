package com.fedebonel.springpetclinic.services;

import com.fedebonel.springpetclinic.model.Vet;

import java.util.Set;

/**
 * A Service that abstracts a repository, this way we avoid using specific implementations in uses
 */
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
