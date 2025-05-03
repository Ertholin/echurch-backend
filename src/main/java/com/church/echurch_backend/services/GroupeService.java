package com.church.echurch_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.echurch_backend.entities.Groupe;
import com.church.echurch_backend.exceptions.GroupeNotFoundException;
import com.church.echurch_backend.repositories.GroupeRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    public Groupe enregistrerGroupe(Groupe groupe){
        log.info("Saving a group");
        Groupe groupeEnregistre = groupeRepository.save(groupe);
        return groupeEnregistre;
    }

    
    public Groupe modifierGroupe(Groupe groupe) {
        log.info("Updating a group");
        Groupe groupeEnregistre = groupeRepository.save(groupe);
        return groupeEnregistre;
    }

    
    public Groupe voirFicheGroupe(String idGroupe) throws GroupeNotFoundException {
        Groupe groupe = groupeRepository.findById(idGroupe)
            .orElseThrow(() -> new GroupeNotFoundException("Groupe non trouvé"));
        return groupe;
    }

    
    public void supprimerGroupe(String idGroupe) {
        groupeRepository.deleteById(idGroupe);
    }
    
    public List<Groupe> listerGroupes() {
        List<Groupe> liste = groupeRepository.findAll();
        return liste;
    }

    // public List<Groupe> rechercherGroupe(String motCle) {
    //     List<Groupe> groupes = groupeRepository.rechercherGroupe(motCle);
    //     return groupes;
    // }
    
    
}
