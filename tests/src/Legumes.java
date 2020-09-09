import diplo.tools.TConsole;
/*
public class Legumes {
    public static Produits tomates = new Produits("Tomates", 2.0, 0,0,0,0);
    public static Produits pommesDeTerre = new Produits("Pommes de terre", 1, 0,0,0,0);
    public static Produits poivrons = new Produits("Poivrons", 4, 0,0,0,0);
    public static Produits oignons = new Produits("Oignons", 1,0,0,0,0);
    public static void main(String[] arg) {

        TConsole.toprintln("1 - " + tomates.getNom() + " : " + tomates.getPrixAuKilo() + "€");
        TConsole.toprintln("2 - " + pommesDeTerre.getNom() + " : " + pommesDeTerre.getPrixAuKilo() + "€");
        TConsole.toprintln("3 - " + poivrons.getNom() + " : " + poivrons.getPrixAuKilo() + "€");
        TConsole.toprintln("4 - " + oignons.getNom() + " : " + oignons.getPrixAuKilo() + "€");

        Legumes.commande();

        TConsole.toprintln("Total tomates : - Poids demandé : " + tomates.getTotalPoids() + " kg " + "Prix : " + (float) tomates.getTotalProduit() + "€"
                + "\nTotal pommes de terre : - Poids demandé : " + pommesDeTerre.getTotalPoids() + " kg " + "Prix : " + (float) pommesDeTerre.getTotalProduit() + "€"
                + "\nTotal poivrons : - Poids demandé : " + poivrons.getTotalPoids() + " kg " + "Prix : " + (float) poivrons.getTotalProduit() + "€"
                + "\nTotal oignons : - Poids demandé : " + oignons.getTotalPoids() + " kg " + "Prix : " + (float) oignons.getTotalProduit() + "€"
                + "\nTotal général : " + (float) (tomates.getTotalProduit() + pommesDeTerre.getTotalProduit() + poivrons.getTotalProduit() + oignons.getTotalProduit()) + "€");
    }


    public static void commande() {
        TConsole.toprintln("Votre choix 1, 2, 3 ou 4 - 0 pour finaliser");

        int rep = Tools.askThing(1);
        if(rep == 1 || rep == 2 || rep == 3 || rep == 4 || rep == 0) {
            switch(rep) {
                case 1:
                    TConsole.toprintln("Quel poids pour les tomates");

                    tomates.setPoids(Tools.askThing(0.1));
                    tomates.setTotalPoids(tomates.getTotalPoids() + tomates.getPoids());

                    tomates.setTotal(tomates.calcul(tomates.getPrixAuKilo(), (float) tomates.getPoids()));
                    tomates.setTotalProduit(tomates.getTotalProduit() + tomates.getTotal());
                    TConsole.toprintln("Le prix total pour les tomates est de : " + (float) tomates.getTotalProduit() + "€ pour un poids total de : " + tomates.getTotalPoids() + " kilos");

                    break;
                case 2:
                    TConsole.toprintln("Quel poids pour les pommes de terre");

                    pommesDeTerre.setPoids(Tools.askThing(0.1));
                    pommesDeTerre.setTotalPoids(pommesDeTerre.getTotalPoids() + pommesDeTerre.getPoids());

                    pommesDeTerre.setTotal(pommesDeTerre.calcul(pommesDeTerre.getPrixAuKilo(), (float) pommesDeTerre.getPoids()));
                    pommesDeTerre.setTotalProduit(pommesDeTerre.getTotalProduit() + pommesDeTerre.getTotal());
                    TConsole.toprintln("Le prix total pour les pommes de terre est de : " + (float) pommesDeTerre.getTotalProduit() + "€ pour un poids total de : " + pommesDeTerre.getTotalPoids() + " kilos");

                    break;
                case 3:
                    TConsole.toprintln("Quel poids pour les poivrons");

                    poivrons.setPoids(Tools.askThing(0.1));
                    poivrons.setTotalPoids(poivrons.getTotalPoids() + poivrons.getPoids());

                    poivrons.setTotal(poivrons.calcul(poivrons.getPrixAuKilo(), (float) poivrons.getPoids()));
                    poivrons.setTotalProduit(poivrons.getTotalProduit() + poivrons.getTotal());
                    TConsole.toprintln("Le prix total pour les poivrons est de : " + (float) poivrons.getTotalProduit() + "€ pour un poids total de : " + poivrons.getTotalPoids() + " kilos");

                    break;
                case 4:
                    TConsole.toprintln("Quel poids pour les oignons");

                    oignons.setPoids(Tools.askThing(0.1));
                    oignons.setTotalPoids(oignons.getTotalPoids() + oignons.getPoids());

                    oignons.setTotal(oignons.calcul(oignons.getPrixAuKilo(), (float) oignons.getPoids()));
                    oignons.setTotalProduit(oignons.getTotalProduit() + oignons.getTotal());
                    TConsole.toprintln("Le prix total pour les oignons est de : " + (float) oignons.getTotalProduit() + "€ pour un poids total de : " + oignons.getTotalPoids() + " kilos");

                    break;
                case 0:
                    TConsole.toprintln("Facture finale");
                    return;
            }
            Legumes.commande();
        } else {
            Legumes.commande();
        }
    }
}
*/



