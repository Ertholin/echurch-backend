package com.church.echurch_backend.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.church.echurch_backend.dtos.MembreDTO;
import com.church.echurch_backend.entities.Membre;

@Service
public class MembreMapperImpl {
    public MembreDTO fromMembre(Membre membre){
        MembreDTO membreDTO = new MembreDTO();
        BeanUtils.copyProperties(membre, membreDTO);
        return membreDTO;
    }

    public Membre fromMembreDTO(MembreDTO membreDTO){
        Membre membre = new Membre();
        BeanUtils.copyProperties(membreDTO, membre);
        return membre;
    }
}
