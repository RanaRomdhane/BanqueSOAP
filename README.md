# 🏦 BanqueSOAP – Service Web SOAP (JAX-WS / JAXB)

Projet académique démontrant la création, le déploiement et la consommation d'un Web Service SOAP en utilisant JAX-WS, JAXB et Maven. Il inclut également un client SOAP Java généré automatiquement à partir du fichier WSDL.

## 📋 Table des Matières

- [Objectifs](#-objectifs)
- [Fonctionnalités](#-fonctionnalités)
- [Structure du Projet](#-structure-du-projet)
- [Technologies](#️-technologies)
- [Installation](#️-installation)
- [Déploiement du Web Service](#-déploiement-du-web-service)
- [WSDL](#-wsdl)
- [Test avec SOAP UI](#-test-avec-soap-ui)
- [Client SOAP](#-client-soap)
- [Exemples d'Utilisation](#-exemples-dutilisation)
- [Concepts Clés](#-concepts-clés)
- [Auteur](#-auteur)

## 🎯 Objectifs

Ce projet a pour but de mettre en pratique :

- Création d'un service web SOAP Bottom-Up
- Annotation JAX-WS sur un POJO
- Sérialisation/désérialisation XML avec JAXB
- Génération du fichier WSDL
- Test du service via SOAP UI
- Développement d'un client SOAP Java via wsimport

## ✨ Fonctionnalités

- ✔ Convertir un montant TND → EUR
- ✔ Récupérer un compte (id, solde, date création)
- ✔ Lister tous les comptes disponibles
- ✔ Annotations JAXB pour la sérialisation XML
- ✔ Fichier WSDL auto-généré
- ✔ Client Java créé automatiquement via wsimport

## 🛠 Technologies

| Technologie | Description |
|---|---|
| Java 17 | Langage principal |
| JAX-WS RI 4.0.3 | Implémentation SOAP |
| JAXB | Mapping XML ↔ Java |
| Maven | Build & dépendances |
| SOAP UI | Tests SOAP |
| wsimport | Génération du client Java |

## 📂 Structure du Projet

```
BanqueSOAP/
├── src/main/java/
│   ├── entities/
│   │   └── Compte.java                 # POJO + JAXB
│   ├── service/
│   │   ├── BanqueService.java          # Interface SOAP
│   │   └── BanqueServiceImpl.java       # Implémentation JAX-WS
│   └── server/
│       └── ServeurJWS.java             # Publication du WS via Endpoint
├── wsdl/                               # WSDL généré (optionnel)
├── pom.xml                             # Dépendances JAX-WS
└── README.md
```

## ⚙️ Installation

### 1️⃣ Cloner le projet

```bash
git clone https://github.com/RanaRomdhane/BanqueSOAP.git
cd BanqueSOAP
```

### 2️⃣ Installer les dépendances Maven

```bash
mvn clean install
```

## 🚀 Déploiement du Web Service

Le serveur JAX-WS est lancé via la classe : `server/ServeurJWS.java`

### Exécution

```bash
mvn compile exec:java -Dexec.mainClass="com.example.server.ServeurJWS"
```

### 📌 URL du service

```
http://localhost:9090/BanqueWS?wsdl
```

(selon ton port, cela peut être 8888, 9000, etc.)

## 📑 WSDL

### Consulter le WSDL

```
http://localhost:9090/BanqueWS?wsdl
```

### Générer les classes Java (client)

```bash
wsimport -keep http://localhost:9090/BanqueWS?wsdl
```

## 🧪 Test avec SOAP UI

1. Ouvrez SOAP UI
2. Cliquez sur **New SOAP Project**
3. Saisissez l'URL : `http://localhost:9090/BanqueWS?wsdl`
4. Les opérations disponibles apparaîtront :
   - `convert`
   - `getCompte`
   - `listeComptes`

### Exemple requête SOAP — convert 5000

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://service.example.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <web:convert>
         <montantTND>5000</montantTND>
      </web:convert>
   </soapenv:Body>
</soapenv:Envelope>
```

## 💻 Client SOAP

Le client est généré automatiquement via le plugin Maven `jaxws-maven-plugin`.

### Configuration dans pom.xml

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>jaxws-maven-plugin</artifactId>
    <version>2.6</version>
    <configuration>
        <wsdlUrls>
            <wsdlUrl>http://localhost:9090/BanqueWS?wsdl</wsdlUrl>
        </wsdlUrls>
        <packageName>com.example.proxy</packageName>
    </configuration>
</plugin>
```

### Exemple client Java

```java
public class ClientWS {
    public static void main(String[] args) {
        BanqueWSSOAP service = new BanqueWSSOAP();
        BanqueService stub = service.getBanqueServicePort();
        
        System.out.println("Conversion 4500 TND : " + stub.convert(4500));
        
        Compte c = stub.getCompte(3);
        System.out.println("Compte ID = " + c.getCode());
        System.out.println("Solde = " + c.getSolde());
    }
}
```

## 🧩 Exemples d'Utilisation

### Convertir un montant

```java
convert(1000.0) → 300.00 EUR
```

### Consulter un compte

```java
getCompte(1) → Compte { 
    id=1, 
    solde=2500.75, 
    dateCreation="2025-01-15" 
}
```

### Lister les comptes

```java
listeComptes() → ArrayList<Compte>
```

## 📚 Concepts Clés

### ✔ JAX-WS (SOAP)

- Basé sur WSDL
- Types forts (XSD)
- Approches contract-first et bottom-up

### ✔ JAXB

Annotations principales :
- `@XmlRootElement`
- `@XmlTransient`
- `@XmlAccessorType(XmlAccessType.FIELD)`

### ✔ wsimport

Permet la génération automatique de :
- Interfaces
- Stubs SOAP
- Classes Java pour les opérations

## 👩‍💻 Auteur

**Rana ROMDHANE**
- 3ème année Génie Informatique
- Université de Carthage — ENICarthage
- Module : Service Oriented Computing (2025–2026)

---

⭐ **N'oubliez pas d'ajouter une étoile si ce projet vous aide !** ⭐
