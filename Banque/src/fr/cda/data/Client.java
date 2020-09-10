package fr.cda.data;

import java.util.ArrayList;

public class Client {
    private Integer numeroClient;
    private String nomClient;
    private String prenomClient;
    private CompteCourant compteCourant;
    private static ArrayList<Client> clients = new ArrayList<>();

    public Client(Integer numeroClient, String nomClient, String prenomClient, Integer code, Float solde, Integer decouvert) {
        this.numeroClient = numeroClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.compteCourant = new CompteCourant(code, solde, decouvert);
    }

    public void addClient() {
        clients.add(this);
    }

    public Integer getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(Integer numeroClient) {
        this.numeroClient = numeroClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static void setClients(ArrayList<Client> clients) {
        Client.clients = clients;
    }

    public CompteCourant getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }
}
