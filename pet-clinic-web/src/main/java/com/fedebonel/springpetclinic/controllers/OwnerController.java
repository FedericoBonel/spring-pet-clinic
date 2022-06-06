package com.fedebonel.springpetclinic.controllers;

import com.fedebonel.springpetclinic.model.Owner;
import com.fedebonel.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


/**
 * Controller for the pet owners
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * Custom HTTP parameter binding to protect objects id from form inputs
     */
    @InitBinder
    public void setAllowedFields(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }

    /**
     * Handler of GET requests to show owners page
     */
    @GetMapping({"/index", "/index.html"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    /**
     * Handler of GET requests to show a specific owner
     */
    @GetMapping({"/{ownerId}"})
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject("owner", ownerService.findById(ownerId));
        return modelAndView;
    }

    /**
     * Handler of GET requests to search for a specific owner
     */
    @GetMapping({"/find"})
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    /**
     * Handler of GET requests to process searches for specific owners
     */
    @GetMapping
    public String processFindOwners(Owner owner, BindingResult bindingResult, Model model){
        // Allow parameterless searches for seeing all owners
        if (owner.getLastName() == null) {
            // This will allow the JPA repository to get all the owners
            owner.setLastName("");
        }

        // Get all the owners with that or similar to that lastname
        List<Owner> owners = ownerService.findByLastNameContainingIgnoreCase(owner.getLastName());

        if (owners.isEmpty()) {
            // If no owners, then show error page
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (owners.size() == 1) {
            // If 1 owner redirect to that owner
            model.addAttribute("owner", owners.get(0));
            return "redirect:/owners/" + owners.get(0).getId();
        } else {
            // If multiple owners redirect to the list of owners
            model.addAttribute("listOwners", owners);
            return "owners/ownersList";
        }
    }

    @GetMapping("/new")
    public String createOwnerForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String createOwner(@Valid Owner owner, BindingResult result) {
        // If there were any errors show again the form because the owner is invalid
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        }

        Owner savedOwner = ownerService.save(owner);
        return "redirect:/owners/" + savedOwner.getId();
    }

    @GetMapping("/{ownerId}/edit")
    public String editOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerId));
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String editOwner(@PathVariable Long ownerId, @Valid Owner owner, BindingResult result) {
        // If there were any errors show again the form because the owner is invalid
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        }
        // The id is is not being binded so we need to explicitly set it
        owner.setId(ownerId);

        Owner savedOwner = ownerService.save(owner);
        return "redirect:/owners/" + savedOwner.getId();
    }
}
