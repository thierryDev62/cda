public class Assurance {
    /**
     *  Calcul assurance
     * @param arg
     */
    public static void main(String[] arg) {

        /* Variables init */
        boolean ageSup25, totalAccident0, totalAccident1, totalAccident2, clientFidele, plusDeuxAnsPermis;
        int anciennete, age, anneesPermis, nombreAccident, tarifRouge = 200, tarifOrange = 150, tarifVert = 100, tarifBleu = 50;
        age = 26;
        anneesPermis = 3;
        nombreAccident = 1;
        anciennete = 6;

        /* Booleens des conditions */
        ageSup25 = age >= 25  ? true : false;
        plusDeuxAnsPermis = anneesPermis > 2 ? true : false;
        totalAccident0 = nombreAccident == 0 ? true : false;
        totalAccident1 = nombreAccident == 1 ? true : false;
        totalAccident2 = nombreAccident == 2 ? true : false;
        clientFidele = (anciennete > 5) ? true : false;

        /* Cas 1 */
        if(!ageSup25 && !plusDeuxAnsPermis) {
            System.out.println("Vous avez :\n" + anciennete + " années d'ancienneté\n" + age + " ans\n" + nombreAccident + " accidents\n" + anneesPermis + " années de permis");
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
            System.out.println("Vous avez :\n" + anciennete + " années d'ancienneté\n" + age + " ans\n" + nombreAccident + " accidents\n" + anneesPermis + " années de permis");
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
            System.out.println("Vous avez :\n" + anciennete + " années d'ancienneté\n" + age + " ans\n" + nombreAccident + " accidents\n" + anneesPermis + " années de permis");
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
