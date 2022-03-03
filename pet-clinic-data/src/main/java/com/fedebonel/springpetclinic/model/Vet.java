package com.fedebonel.springpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * POJO Of a vet working at the store
 */
public class Vet extends Person {

    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
