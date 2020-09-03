public class Arrays {
    public static void main(String[] arg) {
        Tools.toprint("Tableau à une dimension");
        String[] tableauMots = {"Jean", "Robert", "Paul"};
        for (String tableauMot : tableauMots) {
            Tools.toprint(tableauMot);
        }

        Tools.toprint("Tableau à deux dimensions");
        String[][] tabTwoDimensions = {{"chien", "chat", "poisson"}, {"oiseau", "mamifère", "insecte"}, {"toto", "tata", "titi"}};
        for(String[] animal : tabTwoDimensions) {
            for(String others : animal) {
                Tools.toprint(others);
            }
        }
    }
}

