package com.fedebonel.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the pet owners
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {
    @RequestMapping({"", "/index", "/index.html"})
    public String listOwners(){

        return "owners/index";
    }
}
