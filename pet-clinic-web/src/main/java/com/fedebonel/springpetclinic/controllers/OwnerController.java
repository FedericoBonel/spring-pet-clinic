package com.fedebonel.springpetclinic.controllers;

import com.fedebonel.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


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
     * Handler of GET requests to show owners page
     */
    @GetMapping({"", "/index", "/index.html"})
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
    @RequestMapping({"/find"})
    public String findOwners(Model model){
        return "notimplemented";
    }
}
