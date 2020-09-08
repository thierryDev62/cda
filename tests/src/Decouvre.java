import diplo.tools.TConsole;

public class Decouvre {
    public static void main(String[] arg) {
        int[] tab = {1, 2, 3, 4, 5};
        aVousDeDecouvrir(tab, 5, 0, 5);
    }
    public static int aVousDeDecouvrir(int t[], int entier, int indexMin, int longueur) {
        int indexResult = 0;
        if( t[(longueur-indexMin)/2+indexMin] != entier ) {
            if( t[(longueur-indexMin)/2+indexMin] < entier ) {
                return aVousDeDecouvrir(t, entier, (longueur-indexMin)/2+indexMin, longueur);
            }else {
                return aVousDeDecouvrir(t, entier, indexMin, (longueur-indexMin)/2+indexMin);
            }
        } else{
            indexResult = (longueur-indexMin)/2+indexMin;
        }
        TConsole.toprintln(indexResult);
        return indexResult;
    }
}


