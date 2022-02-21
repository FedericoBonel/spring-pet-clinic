package com.fedebonel.springpetclinic.model;

import java.time.LocalDate;

/**
 * POJO for Pet related to vet
 */
public class Pet extends BaseEntity{

    public PetType petType;
    public Owner owner;
    public LocalDate birthDate;



    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
