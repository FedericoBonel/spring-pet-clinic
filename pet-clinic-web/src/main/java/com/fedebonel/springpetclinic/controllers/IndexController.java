package com.fedebonel.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the requests to the index page
 */
@Controller
@RequestMapping("")
public class IndexController {

    @GetMapping({"index","index.html"})
    public String index() {
        return "index";
    }

    // TODO: Implement the throw error functionality
    @GetMapping({"/oups"})
    public String throwError(Model model){
        return "notimplemented";
    }
}
