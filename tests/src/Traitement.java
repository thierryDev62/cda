import fr.cda.data.Fidelite;
import fr.cda.data.Permis;
import fr.cda.data.Personne;

public class Traitement {
    public static void main(String[] arg) {

        //TODO : faire scanner pour saisir les coordonnées + Voir pour type de permis

        /******************************************************************************************/
        Personne assure = new Personne("Thonon", "James", 26, 0);
        Permis permisAssure = new Permis();
        Fidelite fideliteAssure = new Fidelite();

        permisAssure.setNbrAnneesPermis(1);
        fideliteAssure.setAnciennete(6);
        assure.setPermis(permisAssure);
        assure.setFidelite(fideliteAssure);
        /*****************************************************************************************/

        Integer nbrAnneesPermisAssure = permisAssure.getNbrAnneesPermis(),
                nbrAnneesAnciennete = fideliteAssure.getAnciennete(),
                nbrAccidents = assure.getNbrAccident();

        // Affichage des coordonnées
        System.out.println(
                "\n*****************************************************************" +
                "\nNom : " + assure.getNom() +
                "\nPrénom : " + assure.getPrenom() +
                "\nAge : " + assure.getAge() +
                "\n*****************************************************************" +
                "\nNombre d'années de permis : " + nbrAnneesPermisAssure + " an" + (nbrAnneesPermisAssure > 1 ? "s" : "") +
                "\nAncienneté : " + nbrAnneesAnciennete + " an" + (nbrAnneesAnciennete > 1 ? "s" : "") +
                "\nNombre d'accident : " + nbrAccidents +
                "\n*****************************************************************"
        );

        // On lance le calcul
        calcul(assure.getAge(), permisAssure.getNbrAnneesPermis(), assure.getNbrAccident(), fideliteAssure.getAnciennete());

    }
    public static void calcul(int age, int anneesPermis, int nombreAccident, int anciennete){

        // Initialisation des variables
        boolean ageSup25, totalAccident0, totalAccident1, totalAccident2, clientFidele, plusDeuxAnsPermis;
        int tarifRouge = 200, tarifOrange = 150, tarifVert = 100, tarifBleu = 50;

        // Couleurs
        String ANSI_RED = "\u001B[31m",
                ANSI_GREEN = "\u001B[32m",
                ANSI_BLUE = "\u001B[34m",
                ANSI_ORANGE = "\u001B[33m",
                ANSI_RESET = "\u001B[0m";

        // Phrases sur les tarifs
        String phraseTarifRouge = "Le tarif " + ANSI_RED + "rouge" + ANSI_RESET + " est appliqué soit ",
                phraseTarifOrange = "Le tarif " + ANSI_ORANGE + "orange" + ANSI_RESET + " est appliqué soit ",
                phraseTarifVert = "Le tarif " + ANSI_GREEN + "vert" + ANSI_RESET + " est appliqué soit ",
                phraseTarifBleu = "Le tarif " + ANSI_BLUE + "bleu" + ANSI_RESET + " est appliqué soit ",
                separateur = "\n*****************************************************************\n";

        // Booleens des conditions
        ageSup25 = age >= 25;
        plusDeuxAnsPermis = anneesPermis > 2;
        totalAccident0 = nombreAccident == 0;
        totalAccident1 = nombreAccident == 1;
        totalAccident2 = nombreAccident == 2;
        clientFidele = anciennete > 5;

        /**
         * Cas 1
         * Un conducteur de moins de 25 ans et titulaire du permis depuis moins de deux ans,
         * se voit attribuer le tarif rouge, si toutefois il n'a jamais été responsable d'accident.
         * Sinon, la compagnie refuse de l'assurer.
         */

        if(!ageSup25 && !plusDeuxAnsPermis) {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println(phraseTarifRouge + tarifRouge + "€" + separateur);
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println("Le tarif " + ANSI_ORANGE + "orange" + ANSI_RESET + " est appliqué" + separateur);
                    System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                }
            } else {
                System.out.println("Désolé mais c'est un refus");
            }

            /**
             * Cas 2
             * Un conducteur de moins de 25 ans et titulaire du permis depuis plus de deux ans,
             * ou de plus de 25 ans mais titulaire du permis depuis moins de deux ans a le droit au
             * tarif orange s'il n'a jamais provoqué d'accident, au tarif rouge pour un accident,
             * sinon il est refusé.
             */

        } else if(!ageSup25 || !plusDeuxAnsPermis) {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println(phraseTarifOrange + tarifOrange + "€" + separateur);
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                } else {
                    System.out.println(phraseTarifVert + tarifVert + "€" + separateur);
                    System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                }
            } else if(totalAccident1) {
                if(!clientFidele) {
                    System.out.println(phraseTarifRouge + tarifRouge + "€" + separateur);
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println(phraseTarifOrange + tarifOrange + "€" + separateur);
                    System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                }
            } else {
                System.out.println("Désolé mais c'est un refus");
            }

            /**
             * Cas 3
             * Un conducteur de plus de 25 ans titulaire du permis depuis plus de deux ans bénéficie
             * du tarif vert s'il n'est à l'origine d'aucun accident et du tarif orange pour un accident,
             * du tarif rouge pour deux accidents, et refusé au-delà.
             */

        } else {
            if(totalAccident0) {
                if(!clientFidele) {
                    System.out.println(phraseTarifVert + tarifVert + "€" + separateur);
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                    }
                } else {
                    System.out.println(phraseTarifBleu + tarifBleu + "€" + separateur);
                    System.out.println("Montant avant remise : " + tarifBleu + "€\nMontant après remise : " + remise(tarifBleu, anciennete) + "€");
                }
            } else if(totalAccident1) {
                if(!clientFidele) {
                    System.out.println(phraseTarifOrange + tarifOrange + "€" + separateur);
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                    }
                } else {
                    System.out.println(phraseTarifVert + tarifVert + "€" + separateur);
                    System.out.println("Montant avant remise : " + tarifVert + "€\nMontant après remise : " + remise(tarifVert, anciennete) + "€");
                }
            } else if(totalAccident2) {
                if(!clientFidele) {
                    System.out.println(phraseTarifRouge + tarifRouge + "€" + separateur);
                    if(anciennete > 0) {
                        System.out.println("Montant avant remise : " + tarifRouge + "€\nMontant après remise : " + remise(tarifRouge, anciennete) + "€");
                    }
                } else {
                    System.out.println(phraseTarifOrange + tarifOrange + "€" + separateur);
                    System.out.println("Montant avant remise : " + tarifOrange + "€\nMontant après remise : " + remise(tarifOrange, anciennete) + "€");
                }
            } else {
                System.out.println("Désolé mais c'est un refus");
            }
        }
    }
    /**
     * Calcul de la remise
     * Pour encourager la fidélité des clients acceptés, la compagnie propose un contrat
     * de la couleur immédiatement la plus avantageuse s'il est entré dans la maison depuis
     * plus de cinq ans. Ainsi, s'il satisfait à cette exigence, un client normalement "vert"
     * devient "bleu", un client normalement "orange" devient "vert", et le "rouge" devient orange.
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
