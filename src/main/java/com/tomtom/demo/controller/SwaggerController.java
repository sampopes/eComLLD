package com.tomtom.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Rest Controller for Swagger UI.
 */
@Controller
public class SwaggerController {

    /**
     * @return String
     */
    @GetMapping(value = "/")
    public String redirect() {
        return "redirect:/swagger-ui.html";
    }
}
