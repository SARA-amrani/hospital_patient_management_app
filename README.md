# 🏥 Projet HospitalApplication - ORM JPA Hibernate Spring Data

##  Objectif de l'activité

Mettre en œuvre l'ORM avec **JPA/Hibernate** et **Spring Data JPA** pour créer un mini-projet de gestion de patients. L'activité est ensuite enrichie avec les entités **Médecin**, **Rendez-vous**, **Consultation**, **User** et **Role**, pour illustrer les relations entre entités et la migration de la base de données H2 vers MySQL.

---
## Introduction
Ce projet est une application de gestion d’un hôpital, développée dans le cadre d’une activité pratique dirigée par **Mohamed Youssfi**. L'objectif est de mettre en œuvre une architecture complète utilisant **Spring Boot**, **JPA**, **Hibernate**, **Spring Data**, et **REST API**, afin de modéliser des entités comme les `Patients`, `Médecins`, `RendezVous`, et `Consultations`.

L’application commence avec une base de données embarquée H2, puis migre vers **MySQL** pour un usage plus réaliste.

---

## 🧰 Technologies et outils utilisés

| Technologie      | Rôle |
|------------------|--|
| Java             | Langage principal |
| Spring Boot      | Framework principal |
| Spring Data JPA  | ORM (Mapping Objet-Relationnel) |
| Hibernate        | Implémentation JPA |
| Lombok           | Réduction du code boilerplate |
| H2 Database      | Base de données en mémoire  |
| MySQL            | Base de données relationnelle persistée |
| IntelliJ IDEA Ultimate | IDE de développement                     |

---

## Étapes de Réalisation

### 1. Création du projet Spring Boot

2. Configurez le projet comme suit :
    - Project: Maven
    - Language: Java
    - Spring Boot: 3.4.4
    - Packaging: Jar
    - Java: 21
   
![](src/main/captures/photo1.png)

3. Ajoutez les dépendances:
    - Spring Data JPA
    - H2 Database
    - Spring Web
    - Lombok
   
![](src/main/captures/photo2.png)

### 2. Diagramme de classes

![](src/main/captures/photo3.png)

### 2. Architecture du projet

Voici une vue complète de l’architecture du projet :

![](src/main/captures/photo4.png)

Structure du projet :

```plaintext
ma.enset.hospital
│
├── entities             -> Contient toutes les classes JPA (modèle de données)
│   ├── Patient.java
│   ├── Medecin.java
│   ├── RendezVous.java
│   ├── Consultation.java
│   └── StatusRDV.java (enum)
│
├── repository           -> Interfaces Spring Data JPA (DAO)
│   ├── PatientRepository
│   ├── MedecinRepository
│   ├── RendezvousRepository
│   └── ConsultationRepository
│
├── service              -> Couche service avec la logique métier
│   ├── IHospitalService (interface)
│   └── HospitalServiceImpl (implémentation)
│
├── web                  -> Contrôleurs REST
│   └── PatientRestController
│
└── HospitalApplication  -> Classe principale de démarrage Spring Boot
``` 
    - Rôle des Packages et Classes
> entities : 
Contient les classes d'entité JPA, chacune mappée à une table en base de données :

- Patient: Représente un patient.
  ![](src/main/captures/photo5.png)

- Medecin: Représente un médecin.
  ![](src/main/captures/photo6.png)

- RendezVous: Une entité pour gérer les rendez-vous, liée à un médecin et un patient.
![](src/main/captures/photo7.png)

- Consultation: Détails d’une consultation.
![](src/main/captures/photo8.png)

- StatusRDV: Enum qui indique l'état du rendez-vous (PENDING, CONFIRMED, CANCELLED).
![](src/main/captures/photo9.png)

### Explication des annotations
    @Entity: Marque la classe comme une entité JPA
    
    @Id: Spécifie la clé primaire
    
    @GeneratedValue: Configure la stratégie de génération des ID
    
    @Temporal: Précise le format de la date
    
    Lombok annotations (@Data, @NoArgsConstructor, @AllArgsConstructor): Génèrent automatiquement les getters/setters, constructeurs, etc.

> repository
Contient les interfaces Spring Data JPA, pour interagir avec la base de données.

- PatientRepository: CRUD + requêtes personnalisées pour Patient.
  ![](src/main/captures/photo10.png)

- MedecinRepository: CRUD pour les médecins.
  ![](src/main/captures/photo11.png)

- RendezvousRepository: Pour les rendez-vous.
  ![](src/main/captures/photo12.png)

- ConsultationRepository: Pour les consultations.
  ![](src/main/captures/photo13.png)

> service
Implémente la logique métier de l’application.

- IHospitalService: Interface qui définit les opérations métier (ajouter patient, rendez-vous...).
  ![](src/main/captures/photo14.png)

- HospitalServiceImpl: Implémente cette interface avec injection des repositories.
  ![](src/main/captures/photo15.png)
  ![](src/main/captures/photo16.png)

> web
Expose les services via des endpoints REST.

- PatientRestController: Fournit des API REST pour manipuler les entités (GET, POST, DELETE, etc.).
  ![](src/main/captures/photo17.png)

### ✅ Exemple de résultat JSON depuis l'endpoint `/patients`
![](src/main/captures/photo20.png)


> HospitalApplication
Classe principale annotée avec @SpringBootApplication. Elle exécute le code au démarrage et permet d’injecter des données de test
![](src/main/captures/photo18.png)
![](src/main/captures/photo19.png)


---
### 4. Configuration de l'application

#### Fichier application.properties
Configurez la base de données H2 dans `src/main/resources/application.properties`:
![](src/main/captures/photo21.png)

##### Accès à la console H2 :
![](src/main/captures/photo22.png)
![](src/main/captures/photo23.png)
![](src/main/captures/photo24.png)
![](src/main/captures/photo25.png)
![](src/main/captures/photo26.png)
![](src/main/captures/photo27.png)


### 5. Migration de H2 vers MySQL
➤ Configuration application.properties
![](src/main/captures/photo28.png)

![](src/main/captures/photo29.png)

- La table patient

![](src/main/captures/photo30.png)

- La table medecin

![](src/main/captures/photo31.png)

- La table rendz-vous

![](src/main/captures/photo32.png)

- La table consultation

![](src/main/captures/photo33.png)

## Conclusion
Ce projet nous a permis de comprendre la puissance de l’écosystème Spring Boot dans la gestion d’une application métier complexe avec persistance de données. Grâce à JPA, Hibernate, et Spring Data, le code est plus clair, concis et performant. Il ouvre également la porte vers des applications plus évoluées avec Spring Security, Thymeleaf, ou encore React/Angular en front-end.

## Remerciements
Merci à M. Mohamed Youssfi pour ses explications claires et ses vidéos très pédagogiques.
https://www.youtube.com/watch?v=cz3p4y7tUEs
## Auteur
Réalisé par : [EL AMRANI SARA]

Date : [Mars 2025]