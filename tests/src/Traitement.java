import fr.cda.data.Fidelite;
import fr.cda.data.Permis;
import fr.cda.data.Personne;

public class Traitement {
    public static void main(String[] arg) {
        Permis permisPersonne1 = new Permis();
        permisPersonne1.setNbrAnneesPermis(2);

        Fidelite fidelitePersonne1 = new Fidelite();
        fidelitePersonne1.setAnciennete(15);

        Personne personne1 = new Personne("Thonon", "James", 40, 0);

        personne1.setPermis(permisPersonne1);
        personne1.setFidelite(fidelitePersonne1);

        System.out.println("Nom : " + personne1.getNom() +
                "\nPrénom : " + personne1.getPrenom() +
                "\nAge : " + personne1.getAge() +
                "\nNombre d'années de permis : " + personne1.getPermis().getNbrAnneesPermis() + " ans" +
                "\nAncienneté : " + personne1.getFidelite().getAnciennete() + " ans" +
                "\nNombre d'accident : " + personne1.getNbrAccident()
                );
       calcul(personne1.getAge(), personne1.getPermis().getNbrAnneesPermis(), personne1.getNbrAccident(), personne1.getFidelite().getAnciennete());

    }
    public static void calcul(int age, int anneesPermis, int nombreAccident, int anciennete){
        boolean ageSup25, totalAccident0, totalAccident1, totalAccident2, clientFidele, plusDeuxAnsPermis;
        int tarifRouge = 200, tarifOrange = 150, tarifVert = 100, tarifBleu = 50;

        /* Booleens des conditions */
        ageSup25 = age >= 25;
        plusDeuxAnsPermis = anneesPermis >= 2;
        totalAccident0 = nombreAccident == 0;
        totalAccident1 = nombreAccident == 1;
        totalAccident2 = nombreAccident == 2;
        clientFidele = anciennete > 5;

        /* Cas 1 */
        if(!ageSup25 && !plusDeuxAnsPermis) {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println("Le tarif rouge est appliqué soit " + tarifRouge + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif orange est appliqué");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                }
            } else {
                System.out.println("Désolé mais c'est un refus");
            }

            /* Cas 2 */
        } else if(!ageSup25 && plusDeuxAnsPermis || ageSup25 && !plusDeuxAnsPermis) {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println("Le tarif orange est appliqué soit " + tarifOrange + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif vert est appliqué soit " + tarifVert + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                    }
                }
            } else if(totalAccident1) {
                if(!clientFidele) {
                    System.out.println("Le tarif rouge est appliqué soit " + tarifRouge + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif orange est appliqué soit " + tarifOrange + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                }
            } else {
                System.out.println("Désolé mais c'est un refus");
            }

            /* Cas 3 */
        } else if(ageSup25 && plusDeuxAnsPermis) {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println("Le tarif vert est appliqué soit " + tarifVert + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif bleu est appliqué soit " + tarifBleu + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifBleu + "€\nMontant après remise : " + remise(tarifBleu, anciennete) + "€");
                    }
                }
            } else if(totalAccident1) {
                if(!clientFidele) {
                    System.out.println("Le tarif orange est appliqué soit " + tarifOrange + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif vert est appliqué soit " + tarifVert + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                    }
                }
            } else if(totalAccident2) {
                if(!clientFidele) {
                    System.out.println("Le tarif rouge est appliqué soit " + tarifRouge + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif orange est appliqué soit " + tarifOrange + "€");
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
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
