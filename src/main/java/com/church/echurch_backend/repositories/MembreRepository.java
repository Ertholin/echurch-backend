package com.church.echurch_backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.church.echurch_backend.entities.Membre;

public interface MembreRepository extends JpaRepository<Membre, String>{
    // @Query("Select m from Membre where m.nom like :mc")
    // List<Membre> rechercherMembre(@Param("mc") String motCle);
}
