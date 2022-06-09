package com.fedebonel.springpetclinic.controllers;

import com.fedebonel.springpetclinic.model.Pet;
import com.fedebonel.springpetclinic.model.Visit;
import com.fedebonel.springpetclinic.services.OwnerService;
import com.fedebonel.springpetclinic.services.PetService;
import com.fedebonel.springpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;
    private final OwnerService ownerService;

    public VisitController(VisitService visitService, PetService petService, OwnerService ownerService) {
        this.visitService = visitService;
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }

    /**
     * Handler for GET requests to show the create visit form
     */
    @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String createVisitForm(@PathVariable Long ownerId, @PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        model.addAttribute("visit", visit);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdateVisitForm";
    }

    /**
     * Handler for POST requests to create visits
     */
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String createVisit(@PathVariable Long ownerId,
                              @PathVariable Long petId,
                              @Valid Visit visit,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        }

        // Store the relationship and save the visit
        Pet pet = petService.findById(petId);
        visit.setPet(pet);
        visitService.save(visit);

        return "redirect:/owners/" + ownerId;

    }
}
