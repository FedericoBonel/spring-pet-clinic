package com.fedebonel.springpetclinic.services.map;

import com.fedebonel.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String ownerLastName = "bonel";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(
                new PetTypeServiceMap(),
                new PetServiceMap());
        ownerServiceMap.save(Owner
                .builder()
                .id(ownerId)
                .lastName(ownerLastName)
                .build());
    }

    @Test
    void findAll() {
        Set<Owner> result = ownerServiceMap.findAll();
        assertEquals(1, result.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long expectedId = 2L;
        Owner expectedOwner = Owner.builder().id(expectedId).build();
        Owner savedOwner = ownerServiceMap.save(expectedOwner);
        assertEquals(expectedId, savedOwner.getId());
    }

    @Test
    void saveNoExistingId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastNameFound() {
        Owner ownerFound = ownerServiceMap.findByLastName(ownerLastName);
        assertNotNull(ownerFound);
        assertEquals(ownerLastName, ownerFound.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner ownerFound = ownerServiceMap.findByLastName("notALastName");
        assertNull(ownerFound);
    }
}