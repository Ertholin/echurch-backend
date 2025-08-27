package com.church.echurch_backend.web;

import org.springframework.web.bind.annotation.RestController;

import com.church.echurch_backend.dtos.MembreDTO;
import com.church.echurch_backend.exceptions.MembreNotFoundException;
import com.church.echurch_backend.services.MembreService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@AllArgsConstructor
@Slf4j
public class MembreRestController {
    
    @Autowired
    private MembreService membreService;

    @GetMapping("/membres")
    public List<MembreDTO> getMembres() {
        return membreService.listerMembres();
    }

    @GetMapping("/membre/{id}")
    public MembreDTO getMembre(@PathVariable(name = "id") Long membreId) throws MembreNotFoundException {
        return membreService.voirFicheMembre(membreId);
    }
    
    @PostMapping("/membres")
    public MembreDTO saveMembre(@RequestBody MembreDTO membre) {
        return membreService.enregistrerMembre(membre);
    }

    @PutMapping("/membre/{membreId}")
    public MembreDTO updateMembre(@PathVariable Long membreId, @RequestBody MembreDTO membreDTO) {
        membreDTO.setId(membreId);
        return membreService.modifierMembre(membreDTO);
    }

    @DeleteMapping("/membre/{id}")
    public void deleteMembre(@PathVariable Long id) {
        membreService.supprimerMembre(id);
    }

}
