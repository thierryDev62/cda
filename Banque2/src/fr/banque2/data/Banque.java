package fr.banque2.data;

import java.text.DateFormat;
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
}
