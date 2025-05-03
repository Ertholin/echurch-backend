package com.church.echurch_backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.church.echurch_backend.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, String>{

    //@Query("select g from Groupe where g.nom like :mc")
    //List<Groupe> rechercherGroupe(@Param("mc") String motCle);
}
