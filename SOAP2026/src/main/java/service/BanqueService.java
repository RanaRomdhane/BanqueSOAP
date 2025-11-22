package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import model.Compte;
import java.util.*;

@WebService(name = "BanqueWS")
public class BanqueService {

    private Map<Integer, Compte> comptes = new HashMap<>();
    
    public BanqueService() {
        // Initialisation avec quelques comptes
        comptes.put(1, new Compte(1, 1000.0, "2025-01-01"));
        comptes.put(2, new Compte(2, 2000.0, "2025-01-02"));
        comptes.put(3, new Compte(3, 3000.0, "2025-01-03"));
    }

    @WebMethod
    public double convert(@WebParam(name = "montant") double montant) {
        return montant * 0.3; // Taux de change fictif
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "id") int id) {
        return comptes.get(id);
    }

    @WebMethod
    public List<Compte> listComptes() {
        return new ArrayList<>(comptes.values());
    }
}