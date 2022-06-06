package com.fedebonel.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the requests to the index page
 */
@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping({"index","index.html"})
    public String index() {
        return "index";
    }

    // TODO: Implement the throw error functionality
    @RequestMapping({"/oups"})
    public String throwError(Model model){
        return "notimplemented";
    }
}
