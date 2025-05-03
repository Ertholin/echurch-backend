package com.church.echurch_backend.services;

import java.util.List;

import com.church.echurch_backend.entities.Membre;
import com.church.echurch_backend.exceptions.MembreNotFoundException;

public interface MembreService {
    Membre enregistrerMembre(Membre membre);
    Membre modifierMembre(Membre membre);
    void supprimerMembre(Long idMembre);
    List<Membre> listerMembres();
    //List<Membre> rechercherMembre(String motCle);
    public Membre voirFicheMembre(Long idMembre) throws MembreNotFoundException;
}
