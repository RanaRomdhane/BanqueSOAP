import jakarta.xml.ws.Endpoint;
import service.BanqueService;

public class ServeurJWS {
    public static void main(String[] args) {
        String url = "http://localhost:8585/BanqueService";
        Endpoint.publish(url, new BanqueService());
        System.out.println("Service web déployé sur : " + url);
        System.out.println("WSDL disponible à : " + url + "?wsdl");
    }
}