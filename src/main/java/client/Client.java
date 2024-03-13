package client;

public class Client {

    String nomClient;
    String villeClient;
    String codeClient;

    public Client(String nomClient, String villeClient, String codeClient) {
        this.nomClient = nomClient;
        this.villeClient = villeClient;
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }
}
