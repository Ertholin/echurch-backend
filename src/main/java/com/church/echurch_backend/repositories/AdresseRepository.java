package com.church.echurch_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.church.echurch_backend.entities.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, String>{
    
}
