package fr.banque2.data;

import fr.banque2.data.entity.Client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Banque {
    /**
     * Récupère la date du jour
     * @return la date du jour au format jj/mm/AAAA
     */
    public static String dateDuJour(){
        Date aujourdhui = new Date();
        DateFormat shortDateFormat = DateFormat.getDateInstance(
                DateFormat.SHORT);
        return shortDateFormat.format(aujourdhui);
    }
    public static void sauvegardeClient(ArrayList<Client> liste){
        try {
            FileOutputStream fos = new FileOutputStream("src/fr/banque2/data/donnees/clients.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(liste);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
