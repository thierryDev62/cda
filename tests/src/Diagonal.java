import diplo.tools.TConsole;

public class Diagonal {
    public static void main(String[] arg) {
        String[][] tabTwoDimensions = {{"a", "b", "c", "d"}, {"e", "f", "g", "h"}, {"i", "j", "k", "l"}, {"m", "n", "n", "p"}};

        for (int i = 0; i < tabTwoDimensions.length; i++) {
            //for (int j = i; j < tabTwoDimensions[i].length; j+=4) {
            TConsole.toprint(tabTwoDimensions[i][i]); // Version Seb
            //}
        }
    }
}
