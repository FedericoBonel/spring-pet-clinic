package com.fedebonel.springpetclinic.services;

import com.fedebonel.springpetclinic.model.Owner;

import java.util.Set;

/**
 * A Service that abstracts a repository, this way we avoid using specific implementations in uses
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
