public class Factoriel {

    private static int order;
    private static int disorder;

    public static void main(String[] arg) {

        Tools.toprintln("Nombre de chevaux partants : ");
        int nbrHorses = Tools.askThing(1);

        Tools.toprintln("Nombre de chevaux joués : ");
        int nbrPlayingHorses = Tools.askThing(1);

        if(nbrPlayingHorses > nbrHorses) {
            Tools.toprintln("Le nombre de chevaux joués doit être suppérieur aux chevaux partants");
        } else {
            order = orderShow(nbrHorses, nbrPlayingHorses);
            disorder = disorderShow(nbrHorses, nbrPlayingHorses);
            Tools.toprintln("Dans l'ordre : " + order);
            Tools.toprintln("Dans le désordre : " + disorder);
        }
    }
    public static int orderShow(int nbrHorses, int nbrPlayingHorses) {
        order = Tools.factorial(nbrHorses) / Tools.factorial(nbrHorses - nbrPlayingHorses);
        return order;
    }
    public static int disorderShow(int nbrHorses, int nbrPlayingHorses) {
        disorder = Tools.factorial(nbrHorses) / (Tools.factorial(nbrPlayingHorses) * Tools.factorial(nbrHorses - nbrPlayingHorses));
        return disorder;
    }
}
