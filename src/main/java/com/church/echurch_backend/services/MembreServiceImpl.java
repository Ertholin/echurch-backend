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
    public MembreDTO enregistrerMembre(MembreDTO membreDTO) {
        log.info("Saving a member");
        Membre membre = dtoMapper.fromMembreDTO(membreDTO);
        Membre membreEnregistre = membreRepository.save(membre);
        return dtoMapper.fromMembre(membreEnregistre);
    }

    @Override
    public MembreDTO voirFicheMembre(Long idMembre) throws MembreNotFoundException {
        Membre membre = membreRepository.findById(idMembre)
            .orElseThrow(() -> new MembreNotFoundException("404: Membre non trouvé"));
        return dtoMapper.fromMembre(membre);
    }


    @Override
    public List<MembreDTO> listerMembres() {
        List<Membre> membres = membreRepository.findAll();
        List<MembreDTO> membreDTOs = membres.stream()
                .map(membre -> dtoMapper.fromMembre(membre))
                .collect(Collectors.toList());
        return membreDTOs;
    }

    @Override
    public MembreDTO modifierMembre(MembreDTO membreDTO) {
        log.info("Updating a member");
        Membre membre = dtoMapper.fromMembreDTO(membreDTO);
        Membre membreEnregistre = membreRepository.save(membre);
        return dtoMapper.fromMembre(membreEnregistre);
    }

    @Override
    public void supprimerMembre(Long idMembre) {
        membreRepository.deleteById(idMembre);
    }


    
}
