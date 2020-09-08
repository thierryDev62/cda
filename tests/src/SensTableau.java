import diplo.tools.TConsole;

public class SensTableau {
    public static void main(String[] arg) {

        String[][] tabTwoDimensions = {{"a", "b", "c", "d"}, {"e", "f", "g", "h"}, {"i", "j", "k", "l"}};

        TConsole.toprint("Dans le sens horizontale :");
       /* for (String[] tabTwoDimension : tabTwoDimensions) {
            for (int j = 0; j < tabTwoDimension.length; j++) {
                String item = tabTwoDimension[j];
                System.out.print(item + " ");
            }
            Tools.toprint(" ");
        }*/

        for (int i = 0; i < tabTwoDimensions.length; i++) {
            for (int j = 0; j < tabTwoDimensions[i].length; j++) {
                System.out.print(tabTwoDimensions[i][j] + " ");
            }
            TConsole.toprint(" ");
        }

        TConsole.toprint("Dans le sens vertical :");
        for(int i = 0; i < tabTwoDimensions[0].length; i++){
            for (int j = 0; j < tabTwoDimensions.length; j++) {
                System.out.print(tabTwoDimensions[j][i] + " ");
            }
            TConsole.toprint(" ");
        }
    }
}
