package com.fedebonel.springpetclinic.services.springdatajpa;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceSDJpaTest {
    final Long ID = 1L;
    final String LAST_NAME = "Bonel";

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerServiceSDJpa ownerServiceSDJpa;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner
                .builder()
                .id(ID)
                .lastName(LAST_NAME)
                .build();
    }

    /* Tests */

    @Test
    void findAll() {
        Set<Owner> expectedSet = new HashSet<>();
        expectedSet.add(returnOwner);
        // Simulate a set
        when(ownerRepository.findAll()).thenReturn(expectedSet);

        Set<Owner> actualSet = ownerServiceSDJpa.findAll();

        assertNotNull(actualSet);
        assertEquals(expectedSet.size(), actualSet.size());
    }

    @Test
    void findByIdFound() {
        // Simulate that owner is sotred in repository
        when(ownerRepository.findById(ID)).thenReturn(Optional.of(returnOwner));

        Owner actualOwner = ownerServiceSDJpa.findById(ID);

        assertNotNull(actualOwner);
        assertEquals(returnOwner.getId(), actualOwner.getId());
    }

    @Test
    void findByIdNotFound() {
        // Simulate that the owner is not contained
        when(ownerRepository.findById(ID)).thenReturn(Optional.empty());

        Owner actualOwner = ownerServiceSDJpa.findById(ID);

        assertNull(actualOwner);
    }

    @Test
    void save() {
        // Simulate that the owner gets saved
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerServiceSDJpa.save(returnOwner);

        assertNotNull(savedOwner);
        assertEquals(returnOwner.getId(), savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceSDJpa.delete(returnOwner);

        // Verify that the repository deletes something when this gets called
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerServiceSDJpa.deleteById(ID);

        // Verify that the repository deletes something by a long id when this gets called
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        // Simulate that the repository contains that owner
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner foundOwner = ownerServiceSDJpa.findByLastName(LAST_NAME);

        assertNotNull(foundOwner);
        assertEquals(LAST_NAME, foundOwner.getLastName());
    }
}
