package fr.banque2.data.entity;

import java.io.*;
import java.util.ArrayList;

public class Sauvegarde {
    private String extension = ".txt";
    private String nomDeFichier;
    private static ArrayList<Sauvegarde> toutesLesDonneesUtilisateurs = new ArrayList<>();

    public Sauvegarde(String nomDeFichier) {
        this.nomDeFichier = nomDeFichier;
        toutesLesDonneesUtilisateurs.add(this);
    }

    public void sauvegardeDonnees() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Hello madmax");

        try {
            FileOutputStream fileOut = new FileOutputStream(this.nomDeFichier + extension);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(al);
            out.close();
            System.out.println("Les données ont bien été sauvegardées !");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void lectureDonnees() {
        ArrayList liste = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream(this.nomDeFichier + extension);
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            liste = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lecture des données :");
        for(Object item : liste) {
            System.out.println(item);
        }
    }

    public String getNomDeFichier() {
        return nomDeFichier;
    }

    public void setNomDeFichier(String nomDeFichier) {
        this.nomDeFichier = nomDeFichier;
    }
}
