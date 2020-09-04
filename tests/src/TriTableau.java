import java.util.Arrays;

public class TriTableau {
    public static void main(String[] arg) {
        int[] tableauNombres = {22, 43, -1, 0, 55, -22, 101};
        Arrays.sort(tableauNombres);

        Tools.toprint(Arrays.toString(tableauNombres));

        // Version avec boucle + affichage
        /*for(int tableauTri : tableauNombres) {
            Tools.toprint(tableauTri + " ");
        }*/

    }
}
