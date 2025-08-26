package com.church.echurch_backend.entities;

import java.util.Date;
import java.util.List;

import com.church.echurch_backend.enums.GroupePosition;
import com.church.echurch_backend.enums.TypeIntegration;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private Date dateIntegration;

    @Enumerated(EnumType.STRING)
    private TypeIntegration typeIntegration;

    @Enumerated(EnumType.STRING)
    private GroupePosition groupePosition;

    @ManyToOne
    private Groupe groupe;

    
    @OneToMany(mappedBy = "membre")
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Adresse> adresses;
    
}
