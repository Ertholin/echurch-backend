package com.church.echurch_backend;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.church.echurch_backend.entities.Adresse;
import com.church.echurch_backend.entities.Groupe;
import com.church.echurch_backend.entities.Membre;
import com.church.echurch_backend.enums.GroupePosition;
import com.church.echurch_backend.enums.GroupeStatus;
import com.church.echurch_backend.enums.TypeIntegration;
import com.church.echurch_backend.repositories.AdresseRepository;
import com.church.echurch_backend.repositories.GroupeRepository;
import com.church.echurch_backend.repositories.MembreRepository;



@SpringBootApplication
public class EchurchBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EchurchBackendApplication.class, args);
	}

	//@Bean
	CommandLineRunner start(MembreRepository membreRepository,
							GroupeRepository groupeRepository,
							AdresseRepository adresseRepository){
		return args -> {
			Groupe groupe = new Groupe();
			groupe.setId(UUID.randomUUID().toString());
			groupe.setNom("Groupe Alpha");
			groupe.setDateCreation(new Date());
			groupe.setGroupeStatus(GroupeStatus.FONCTIONNEL);
			groupeRepository.save(groupe);
			

			Stream.of("Ertho", "Ulysse", "Gerlinoue").forEach(nom ->{
				Membre membre = new Membre();
				membre.setNom(nom);
				membre.setPrenom("PrenomDe" +nom);
				membre.setEmail(membre.getPrenom().toLowerCase() + "@gmail.com");
				membre.setDateIntegration(new Date());
				membre.setTypeIntegration(TypeIntegration.CONVERSION);
				membre.setPhone("000 000 0001");
				membre.setGroupePosition(GroupePosition.MEMBRE);
				membre.setGroupe(groupe);
				membreRepository.save(membre);
			});

			membreRepository.findAll().forEach(memb ->{
				Adresse adresse = new Adresse();
				adresse.setId(UUID.randomUUID().toString());
				adresse.setUnite(725);
				adresse.setRue("De Bourg-Louis");
				adresse.setVille("Terrebonne");
				adresse.setProvince("QC");
				adresse.setPays("Canada");
				adresse.setCodePostal("J6X 1L1");
				adresse.setStartDate(new Date());
				adresse.setEndDate(new Date());
				adresse.setMembre(memb);
				adresseRepository.save(adresse);
			});
		};
	}
}

