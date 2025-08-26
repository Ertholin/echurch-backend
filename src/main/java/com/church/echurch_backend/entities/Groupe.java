package com.church.echurch_backend.entities;

import java.util.Date;
import java.util.List;

import com.church.echurch_backend.enums.GroupeStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Membre> membre;

}
