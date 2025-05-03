package com.church.echurch_backend.web;

import org.springframework.web.bind.annotation.RestController;

import com.church.echurch_backend.entities.Membre;
import com.church.echurch_backend.services.MembreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MembreController {
    
    @Autowired
    private MembreService membreService;

    @GetMapping("/membres")
    public List<Membre> getMembres() {
        return membreService.listerMembres();
    }
    
    @PostMapping("/membres")
    public Membre postMembres(@RequestBody Membre membre) {
        return membreService.enregistrerMembre(membre);
    }
    



}
