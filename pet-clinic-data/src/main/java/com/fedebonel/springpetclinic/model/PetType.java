package com.fedebonel.springpetclinic.model;

/**
 * POJO For the different pet types of the vet
 */
public class PetType extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
