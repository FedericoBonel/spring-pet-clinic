package com.fedebonel.springpetclinic.model;

import java.io.Serializable;

/**
 * Base Entity POJO
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
