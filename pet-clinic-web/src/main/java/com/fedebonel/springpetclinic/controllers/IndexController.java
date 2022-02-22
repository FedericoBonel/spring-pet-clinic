package com.fedebonel.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the requests to the index page
 */
@Controller
public class IndexController {
    // Gets the request and returns a new inflated view of the index.html file
    // for localhost.8080, localhost.8080/, localhost.8080/index, localhost.8080/index.html endpoints
    @RequestMapping({"","/","index","index.html"})
    public String index() {
        return "index";
    }
}
