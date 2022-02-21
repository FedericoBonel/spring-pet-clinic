package com.fedebonel.springpetclinic.services;

import com.fedebonel.springpetclinic.model.Owner;

/**
 * A Service that abstracts a repository, this way we avoid using specific implementations in uses
 */
public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}