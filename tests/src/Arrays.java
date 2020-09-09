import diplo.tools.TConsole;

public class Arrays {
    public static void main(String[] arg) {
        TConsole.toprint("Tableau à une dimension");
        String[] tableauMots = {"Jean", "Robert", "Paul"};
        tableauMots[3] = "Seb";
        for (String tableauMot : tableauMots) {
            TConsole.toprint(tableauMot);
        }

        TConsole.toprint("Tableau à deux dimensions");
        String[][] tabTwoDimensions = {{"chien", "chat", "poisson"}, {"oiseau", "mamifère", "insecte"}, {"toto", "tata", "titi"}};
        for(String[] animal : tabTwoDimensions) {
            for(String others : animal) {
                TConsole.toprint(others);
            }
        }
    }
}

