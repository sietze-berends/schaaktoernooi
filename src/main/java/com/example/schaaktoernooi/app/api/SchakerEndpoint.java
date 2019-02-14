package com.example.schaaktoernooi.app.api;

import com.example.schaaktoernooi.app.controller.SchakerService;
import com.example.schaaktoernooi.app.domain.Schaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SchakerEndpoint {

    @Autowired
    private SchakerService schakerService;

    @GetMapping("/schakers")
    public Iterable<Schaker> alleSchakers() {
        return schakerService.alleSchakersService();
    }
}
