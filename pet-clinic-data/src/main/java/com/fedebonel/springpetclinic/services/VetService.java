package com.fedebonel.springpetclinic.services;

import com.fedebonel.springpetclinic.model.Vet;

/**
 * A Service that abstracts a repository, this way we avoid using specific implementations in uses
 */
public interface VetService extends CrudService<Vet, Long> {

}
