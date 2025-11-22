package client;

import tn.enicarthage.proxy.BanqueServiceService;
import tn.enicarthage.proxy.BanqueWS;
import tn.enicarthage.proxy.Compte;

public class ClientWS {
    public static void main(String[] args) {
        BanqueServiceService service = new BanqueServiceService();
        BanqueWS stub = service.getBanqueWSPort();

        System.out.println("Conversion : " + stub.convert(4500));
        Compte compte = stub.getCompte(3);
        System.out.println("Compte ID : " + compte.getId());
        System.out.println("Solde : " + compte.getSolde());
    }
}