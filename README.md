# Library Management System

## Description

**Library Management System** est une API REST développée avec **Spring Boot** permettant la gestion d'une bibliothèque.
Le projet utilise une architecture moderne basée sur **Spring Security**, **Spring Data JPA**, **MySQL**, **Spring Batch**, **Docker** et **Kubernetes**.

## Technologies

- Java 21
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA / Hibernate
- MySQL
- Spring Batch
- Docker & Docker Compose
- Kubernetes (Minikube)
- Swagger / OpenAPI
- Maven

## Fonctionnalités

- Authentification sécurisée (Register / Login) avec JWT
- Gestion des utilisateurs
- Gestion des livres
- Gestion des auteurs
- Gestion des catégories
- Gestion des emprunts
- Notifications automatiques par email
- Traitement automatique des rappels d'emprunts avec Spring Batch
- Planification des traitements avec `@Scheduled`

## Spring Batch

Le projet utilise **Spring Batch** pour automatiser l'envoi de rappels par email concernant les emprunts arrivant prochainement à échéance.

Le traitement est composé de :

- **Reader** : récupère les emprunts concernés depuis la base de données
- **Processor** : prépare les informations nécessaires à la notification
- **Writer** : envoie les emails de rappel

L'exécution du batch est planifiée avec une expression **CRON**, configurable selon le profil Spring.

## Profils Spring

Le projet utilise deux profils :

- **dev**
- **prod**

## Exécution

### Docker

Construire et démarrer l'application :

```bash
docker compose up -d --build
```

Vérifier les conteneurs :

```bash
docker compose ps
```

Voir les logs :

```bash
docker compose logs -f app
```

Arrêter l'application :

```bash
docker compose down
```

### Kubernetes avec Minikube

Démarrer Minikube :

```bash
minikube start
```

Déployer l'application :

```bash
kubectl apply -f k8s/
```

Vérifier les pods :

```bash
kubectl get pods -n library
```

Vérifier les services :

```bash
kubectl get services -n library
```

Redémarrer l'application après une nouvelle image :

```bash
kubectl rollout restart deployment library-app -n library
```

Vérifier le déploiement :

```bash
kubectl rollout status deployment library-app -n library
```

## Swagger / OpenAPI

Accéder à Swagger avec :

```bash
kubectl port-forward svc/library-app -n library 8080:8080
```

Puis ouvrir :

```
http://localhost:8080/swagger-ui/index.html
```

## Auteur

Sabrina Moufok
