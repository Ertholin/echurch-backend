package com.church.echurch_backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.church.echurch_backend.dtos.MembreDTO;
import com.church.echurch_backend.entities.Membre;
import com.church.echurch_backend.exceptions.MembreNotFoundException;
import com.church.echurch_backend.mappers.MembreMapperImpl;
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
    private MembreMapperImpl dtoMapper;

    @Override
    public Membre enregistrerMembre(Membre membre) {
        log.info("Saving a member");
        
        Membre membreEnregistre = membreRepository.save(membre);

        // membreEnregistre.setId(UUID.randomUUID().toString());
        // membreEnregistre.setDateIntegration(new Date());
        // membreEnregistre.setAdresses(null);
        // membreEnregistre.setGroupePosition(null);


        return membreEnregistre;
    }

    @Override
    public Membre modifierMembre(Membre membre) {
        log.info("Updating a member");
        Membre membreEnregistre = membreRepository.save(membre);
        return membreEnregistre;
    }

    // @Override
    // public Membre voirFicheMembre(Long idMembre) throws MembreNotFoundException {
    //     Membre membre = membreRepository.findById(idMembre)
    //         .orElseThrow(() -> new MembreNotFoundException("Membre non trouvé"));
    //     return membre;
    // }

    // @Override
    // public void supprimerMembre(Long idMembre) {
    //     membreRepository.deleteById(idMembre);
    // }

    @Override
    public List<MembreDTO> listerMembres() {
        List<Membre> membres = membreRepository.findAll();
        List<MembreDTO> membreDTOs = membres.stream()
                .map(membre -> dtoMapper.fromMembre(membre))
                .collect(Collectors.toList());

        return membreDTOs;
    }

    @Override
    public void supprimerMembre(Long idMembre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimerMembre'");
    }

    @Override
    public Membre voirFicheMembre(Long idMembre) throws MembreNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'voirFicheMembre'");
    }

    // @Override
    // public List<Membre> rechercherMembre(String motCle) {
    //     List<Membre> membres = membreRepository.rechercherMembre(motCle);
    //     return membres;
    // }
    
}
