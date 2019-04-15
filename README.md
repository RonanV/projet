## Projet
Pour éditer ce fichier, utiliser le language Markdown


# Installation

Installer Node.js 10.15 en local
Vérification installation depuis le terminal win : 
npm -v
node -v

Installation angular depuis le terminal : 
- npm install -g @angular/cli

# Lancer le front de l'application : 

/projet>ng serve --open

Puis l'appli est visible sur localhost:4200

# Présentation
## Le contexte
Dans le cadre du projet de fin d'année de la licence pro SISW. Nous devons réaliser un site web pour une association.
Nous avons choisi l'association Etoile de Villecresnes, qui est une association sportive regroupant plusieurs sports (Gymnastique Artistique, Trampoline, Zumba mais aussi de la gym adaptée au plus petit).

## Les fonctionnalités

### Fil d' actualité
- Afficher de news de l'association

### Albums
- Afficher sous forme de dispo différent album

### Le club

- Présentation de l'association (Histoire...)
- Présentation des disciplines (Horaires, groupes avec photo...etc)
- Présentation des évènements sous forme de calendrier


### Les inscriptions
- L'utilisateur puisse s'inscrire en donnant ses infos personnelles (nom, prénom, numéro...)
- Lorsque l'inscription est envoyé l'utilisateur est avertie par mail que son inscription est prise en compte.
- L'adhérent puisse de préinscrire pour l'année à venir avec son numéro de licence

### Les comptes
- Chaque adhérent aura son compte pour consulter son espace personnel

Quelques utilisateurs (les responsables de l'association) pourront avoir d'autres droits comme :
- Gérer le fil d'actualité
- Gérer les albums
- Gérer les informations des adhérents (changer les numéros, adresse etc)
- Gérer les informations des groupes (nom de l'entraîneur, horaire, tarif)
- Gestion de la partie trésorerie
- Gérer les demandes d'inscription
	- Envoyer un mail en cas de validation ou de refus

### Les utilisateurs

- Les adhérents / Parents
- Le public extérieur
- Les entraîneurs
- Les responsables de l'association

### L'application mobile (sous Android)

- Login de chaque utilisateur
- Les entraîneurs puissent accéder à leur groupe (info des pratiquants)

### Les technologies
- Angular (site)
- Java (android)
- Spring 
