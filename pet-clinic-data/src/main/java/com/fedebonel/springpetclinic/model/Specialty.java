package com.fedebonel.springpetclinic.model;

/**
 * POJO Of vet specialties
 */
public class Specialty extends BaseEntity {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
