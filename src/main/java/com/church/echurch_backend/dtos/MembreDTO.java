package com.church.echurch_backend.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class MembreDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private Date dateIntegration;

}
