package com.church.echurch_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.church.echurch_backend.entities.Membre;
import com.church.echurch_backend.exceptions.MembreNotFoundException;
import com.church.echurch_backend.repositories.MembreRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class MembreServiceImpl implements MembreService{
    
    private MembreRepository membreRepository;

    @Override
    public Membre enregistrerMembre(Membre membre) {
        log.info("Saving a member");
        Membre membreEnregistre = membreRepository.save(membre);
        return membreEnregistre;
    }

    @Override
    public Membre modifierMembre(Membre membre) {
        log.info("Updating a member");
        Membre membreEnregistre = membreRepository.save(membre);
        return membreEnregistre;
    }

    @Override
    public Membre voirFicheMembre(Long idMembre) throws MembreNotFoundException {
        Membre membre = membreRepository.findById(idMembre)
            .orElseThrow(() -> new MembreNotFoundException("Membre non trouvé"));
        return membre;
    }

    @Override
    public void supprimerMembre(Long idMembre) {
        membreRepository.deleteById(idMembre);
    }

    @Override
    public List<Membre> listerMembres() {
        List<Membre> liste = membreRepository.findAll();
        return liste;
    }

    // @Override
    // public List<Membre> rechercherMembre(String motCle) {
    //     List<Membre> membres = membreRepository.rechercherMembre(motCle);
    //     return membres;
    // }
    
}
