package com.church.echurch_backend.entities;

import java.util.Date;
import java.util.List;

import com.church.echurch_backend.enums.GroupeStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Groupe {
    
    @Id
    private String id;
    private String nom;
    private String description;
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private GroupeStatus groupeStatus;

    @OneToMany(mappedBy = "groupe")
    private List<Membre> membre;

}
