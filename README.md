# Library Management System

## Description

Library Management System est une API REST développée avec **Spring Boot** permettant la gestion d'une bibliothèque. Le projet utilise une architecture moderne intégrant **Apache Kafka**, **Avro**, **Schema Registry**, **MySQL**, **Docker** et **Kubernetes**.

## Technologies

* Java 21
* Spring Boot
* Spring Security (JWT)
* Spring Data JPA / Hibernate
* MySQL
* Apache Kafka
* Apache Avro
* Schema Registry
* Docker & Docker Compose
* Kubernetes (Minikube)
* Swagger / OpenAPI
* Maven

## Fonctionnalités

* Authentification sécurisée (Register / Login) avec JWT
* Gestion des utilisateurs
* Gestion des livres
* Gestion des auteurs
* Gestion des catégories
* Gestion des emprunts
* Communication asynchrone avec Kafka
* Sérialisation des événements avec Apache Avro

## Profils Spring

Le projet utilise deux profils :

* **dev** : développement local
* **prod** : exécution avec Docker et Kubernetes

## Exécution

### Docker

```bash
docker compose up -d
```

### Kubernetes

```bash
kubectl apply -f k8s/
```

Vérifier le déploiement :

```bash
kubectl get pods -n library
```

## Documentation API

Après le port-forward :

```bash
kubectl port-forward svc/library-app -n library 8080:8080
```

Swagger :

```
http://localhost:8080/swagger-ui/index.html
```

## Auteur

**Sabrina Moufok**
