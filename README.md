# echurch-backend

API backend Spring Boot pour l’application eChurch, destinée à centraliser la gestion d’une église :  
gestion des membres, des dons/offrandes, de l’inventaire, des lives, des publications photo, et des groupes.

---

## Fonctionnalités principales

- **Gestion des membres**  
  CRUD des membres avec association à un ou plusieurs groupes (ManyToMany).

- **Gestion des dons / offrandes**  
  Enregistrement des dons, suivi par date et montant, génération automatique de reçus fiscaux (PDF/Word) en fin d’année.

- **Gestion des inventaires**  
  Suivi des stocks (chaises, bibles, matériel audio, etc.) avec historique des mouvements.

- **Gestion des lives & enregistrements**  
  Planification des diffusions, URL de streaming, stockages des enregistrements et métadonnées.

- **Gestion des publications photos**  
  Envoi et archivage des photos prises à chaque culte, avec balisage et date.

- **Gestion des groupes**  
  Création et modification de groupes (Dames, Jeunesse, Musiciens, etc.), et attribution dynamique des membres.

---

## Stack Technique

- **Java 17+**  
- **Spring Boot** (Web, Data JPA, Validation, Security)  
- **Maven**  
- **Base de données**  
  - En développement : H2 embarqué  
  - En production : PostgreSQL
- **Authentification & Sécurité**  
  - Spring Security + JWT  
- **Tests**  
  - JUnit 5, Mockito  

---

## Prérequis

- Java 17 ou supérieur  
- Maven 3.6+  
- (Optionnel) Docker & Docker Compose pour lancer PostgreSQL  

---

## Installation & Lancement

1. **Cloner le dépôt**  
   ```bash
   git clone https://github.com/echurch-backend.git
   cd echurch-backend
