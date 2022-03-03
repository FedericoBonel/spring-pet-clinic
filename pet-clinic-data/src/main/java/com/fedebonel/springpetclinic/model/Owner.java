package com.fedebonel.springpetclinic.model;

import java.util.Set;

/**
 * POJO For owners related to vet
 */
public class Owner extends Person {
    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
