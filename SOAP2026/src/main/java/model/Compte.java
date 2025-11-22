package model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {

    private int id;
    private double solde;

    @XmlTransient
    private String dateCreation;

    // Constructeurs
    public Compte() {}
    
    public Compte(int id, double solde, String dateCreation) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }

    public String getDateCreation() { return dateCreation; }
    public void setDateCreation(String dateCreation) { this.dateCreation = dateCreation; }
}