package com.fedebonel.springpetclinic.controllers;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> data;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        data = new HashSet<>();
        data.add(Owner.builder().id(1L).build());
        data.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception {
        // Simulate the data in the service
        when(ownerService.findAll()).thenReturn(data);

        // Make the http get request
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(data.size())));

        verify(ownerService).findAll();
    }

    @Test
    void findOwners() throws Exception {
        // Make HTTP get request
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(view().name("owners/findOwners"));

        // Verify that there are no interactions with the service
        verifyNoInteractions(ownerService);
    }

    @Test
    void showOwner() throws Exception {
        when(ownerService.findById(anyLong()))
                .thenReturn(data.stream()
                        .filter(owner -> owner.getId().equals(1L)).findFirst().orElse(null));

        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }
}