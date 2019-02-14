package com.example.schaaktoernooi.app.api;

import com.example.schaaktoernooi.app.controller.SchakerService;
import com.example.schaaktoernooi.app.domain.Schaker;
import com.example.schaaktoernooi.app.dto.SchakerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SchakerEndpoint {

    @Autowired
    private SchakerService schakerService;

    @GetMapping("/schakers")
    public Iterable<Schaker> alleSchakers() {
        return schakerService.alleSchakersService();
    }

    @PostMapping("/schakertoevoegen")
    public void voegSchakerToe(@RequestBody SchakerDTO schakerDTO) {
        System.out.println("voeg schaker toe java endpoint");
        schakerService.schakerToevoegenService(schakerDTO);
    }

    @DeleteMapping("schakerverwijderen/{id}")
    public void verwijderSchaker(@PathVariable Long id) {
        schakerService.verwijderSchakerService(id);
    }
}
