package com.church.echurch_backend.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {

    @Id
    private String id;
    private int app;
    private int unite;
    private String rue;
    private String ville;
    private String province;
    private String pays;
    private String codePostal;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "membre_id")
    private Membre membre;

}
