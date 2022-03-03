package com.fedebonel.springpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * POJO Of a vet working at the store
 */
public class Vet extends Person {

    private Set<Speciality> specialties = new HashSet<>();

    public Set<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }
}
