package fr.cda.data;

import java.util.ArrayList;

public class Permis {
    private ArrayList<String> typePermis;
    private Integer nbrAnneesPermis;

    public void addType() {
        typePermis = new ArrayList<String>();
        typePermis.add("A - Permis moto");
        typePermis.add("B - Permis voiture");
        typePermis.add("C - Permis transport de marchandise");
        typePermis.add("D - Permis transport en commun");
    }

    public ArrayList<String> getTypePermis() {
        return typePermis;
    }

    public void setTypePermis(ArrayList typePermis) {
        this.typePermis = typePermis;
    }

    public Integer getNbrAnneesPermis() {
        return nbrAnneesPermis;
    }

    public void setNbrAnneesPermis(Integer nbrAnneesPermis) {
        this.nbrAnneesPermis = nbrAnneesPermis;
    }
}
