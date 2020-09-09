import fr.cda.data.Fidelite;
import fr.cda.data.Permis;
import fr.cda.data.Personne;

public class Traitement {
    public static void main(String[] arg) {
        Personne personne1 = new Personne("Thonon", "James", 26, 0);
        Permis permisPersonne1 = new Permis();
        Fidelite fidelitePersonne1 = new Fidelite();
        permisPersonne1.setNbrAnneesPermis(3);
        fidelitePersonne1.setAnciennete(6);

        personne1.setPermis(permisPersonne1);
        personne1.setFidelite(fidelitePersonne1);

        System.out.println("Nom : " + personne1.getNom() +
                "\nPrénom : " + personne1.getPrenom() +
                "\nAge : " + personne1.getAge() +
                "\nNombre d'années de permis : " + personne1.getPermis().getNbrAnneesPermis() + " ans" +
                "\nAncienneté : " + personne1.getFidelite().getAnciennete() + " ans" +
                "\nNombre d'accident : " + personne1.getNbrAccident()
                );
       calcul(personne1.getAge(), permisPersonne1.getNbrAnneesPermis(), personne1.getNbrAccident(), fidelitePersonne1.getAnciennete());

    }
    public static void calcul(int age, int anneesPermis, int nombreAccident, int anciennete){
        boolean ageSup25, totalAccident0, totalAccident1, totalAccident2, clientFidele, plusDeuxAnsPermis;
        int tarifRouge = 200, tarifOrange = 150, tarifVert = 100, tarifBleu = 50;
        String ANSI_RED = "\u001B[31m", ANSI_GREEN = "\u001B[32m", ANSI_BLUE = "\u001B[34m", ANSI_ORANGE = "\u001B[33m", ANSI_RESET = "\u001B[0m";

        /* Booleens des conditions */
        ageSup25 = age >= 25;
        plusDeuxAnsPermis = anneesPermis > 2;
        totalAccident0 = nombreAccident == 0;
        totalAccident1 = nombreAccident == 1;
        totalAccident2 = nombreAccident == 2;
        clientFidele = anciennete > 5;

        /* Cas 1 */
        if(!ageSup25 && !plusDeuxAnsPermis) {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println("Le tarif " + ANSI_RED + "rouge" + ANSI_RESET + " est appliqué soit " + tarifRouge + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif " + ANSI_ORANGE + "orange" + ANSI_RESET + " est appliqué");
                    System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                }
            } else {
                System.out.println("Désolé mais c'est un refus");
            }

            /* Cas 2 */
        } else if(!ageSup25 || !plusDeuxAnsPermis) {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println("Le tarif " + ANSI_ORANGE + "orange" + ANSI_RESET + " est appliqué soit " + tarifOrange + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif " + ANSI_GREEN + "vert" + ANSI_RESET + " est appliqué soit " + tarifVert + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                    }
                }
            } else if(totalAccident1) {
                if(!clientFidele) {
                    System.out.println("Le tarif " + ANSI_RED + "rouge" + ANSI_RESET + " est appliqué soit " + tarifRouge + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif " + ANSI_ORANGE + "orange" + ANSI_RESET + " est appliqué soit " + tarifOrange + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                }
            } else {
                System.out.println("Désolé mais c'est un refus");
            }

            /* Cas 3 */
        } else {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println("Le tarif " + ANSI_GREEN + "vert" + ANSI_RESET + " est appliqué soit " + tarifVert + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif " + ANSI_BLUE + "bleu" + ANSI_RESET + " est appliqué soit " + tarifBleu + "€");
                    System.out.println("Montant avant remise : " + tarifBleu + "€\nMontant après remise : " + remise(tarifBleu, anciennete) + "€");
                }
            } else if(totalAccident1) {
                if(!clientFidele) {
                    System.out.println("Le tarif " + ANSI_ORANGE + "orange" + ANSI_RESET + " est appliqué soit " + tarifOrange + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif " + ANSI_GREEN + "vert" + ANSI_RESET + " est appliqué soit " + tarifVert + "€");
                    System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                }
            } else if(totalAccident2) {
                if(!clientFidele) {
                    System.out.println("Le tarif " + ANSI_RED + "rouge" + ANSI_RESET + " est appliqué soit " + tarifRouge + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif " + ANSI_ORANGE + "orange" + ANSI_RESET + " est appliqué soit " + tarifOrange + "€");
                    System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                }
            } else {
                System.out.println("Désolé mais c'est un refus");
            }
        }
    }
    /**
     * Calcul de la remise
     * @param montantCouleur
     * @param anneesFidelite
     * @return
     */
    public static int remise(int montantCouleur, int anneesFidelite ) {
        int montantApresRemise;
        if(anneesFidelite <= 5) {
            montantApresRemise = montantCouleur - (montantCouleur * (anneesFidelite * 5) / 100);
        } else {
            montantApresRemise = montantCouleur - (montantCouleur * (5 * 5) / 100);
        }
        return montantApresRemise;
    }
}
