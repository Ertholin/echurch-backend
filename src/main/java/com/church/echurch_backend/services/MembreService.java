package com.church.echurch_backend.services;

import java.util.List;

import com.church.echurch_backend.dtos.MembreDTO;
import com.church.echurch_backend.exceptions.MembreNotFoundException;

public interface MembreService {
    MembreDTO enregistrerMembre(MembreDTO membreDTO);
    List<MembreDTO> listerMembres();
    //List<Membre> rechercherMembre(String motCle);
    MembreDTO voirFicheMembre(Long idMembre) throws MembreNotFoundException;
    MembreDTO modifierMembre(MembreDTO membreDTO);
    void supprimerMembre(Long idMembre);
    
}
