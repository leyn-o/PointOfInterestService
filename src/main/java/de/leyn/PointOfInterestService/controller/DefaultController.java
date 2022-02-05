package de.leyn.PointOfInterestService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping
    public String defaultEndpoint() {
        return "Hello world!";
    }
}
