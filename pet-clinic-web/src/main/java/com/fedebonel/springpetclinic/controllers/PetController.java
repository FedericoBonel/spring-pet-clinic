package com.fedebonel.springpetclinic.controllers;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.model.Pet;
import com.fedebonel.springpetclinic.model.PetType;
import com.fedebonel.springpetclinic.services.OwnerService;
import com.fedebonel.springpetclinic.services.PetService;
import com.fedebonel.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    /**
     * Create a types attribute in every request model object that's being used in this controller
     */
    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    /**
     * Create an owner attribute in every request model object that's being used in this controller
     */
    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return ownerService.findById(ownerId);
    }

    /**
     * Custom HTTP parameter binding to protect objects id from form inputs
     */
    @InitBinder("owner")
    public void setAllowedFields(WebDataBinder binder){
        binder.setDisallowedFields("id");
    }

    /**
     * Handler for GET requests to show the pet creation form
     */
    @GetMapping("/pets/new")
    public String createPetForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    /**
     * Handler for POST requests to create new pets
     */
    @PostMapping("/pets/new")
    public String createPet(Owner owner, Model model, BindingResult result, @Valid Pet pet) {
        // Check if pet already exists
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        }

        pet.setOwner(owner);
        petService.save(pet);
        return "redirect:/owners/" + owner.getId();
    }

    /**
     * Handler for GET requests to show the pet update form
     */
    @GetMapping("pets/{petId}/edit")
    public String updatePetForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return "pets/createOrUpdatePetForm";
    }

    /**
     * Handler for POST requests to update a pet
     */
    @PostMapping("pets/{petId}/edit")
    public String updatePet(@Valid Pet pet, BindingResult result, Owner owner, Model model) {

        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        }

        pet.setOwner(owner);
        petService.save(pet);
        return "redirect:/owners/" + owner.getId();
    }

}
