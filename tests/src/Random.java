import java.util.Scanner;

public class Random {
    public static void main(String[] arg) {
        int chiffreCache = Tools.intRandom(), chiffreSaisi;
        boolean trouve = false;
        //System.out.println(chiffreCache + " (chiffre caché)");
        while(!trouve) {
            chiffreSaisi = print();
            if(chiffreSaisi < 0 || chiffreSaisi > 100) {
                System.out.println("Le nombre saisi doit être entre 0 et 100");
            } else {
                if(chiffreSaisi < chiffreCache) {
                    System.out.println("Plus grand");
                } else if(chiffreSaisi > chiffreCache) {
                    System.out.println("Plus petit");
                } else {
                    System.out.println("Bravo !");
                    trouve = true;
                }
            }
        }
    }

    public static int print() {
        int nombre;
        System.out.println("Veuillez saisir un entier de 0 à 100 pour trouver le chiffre mystère");
        Scanner sc = new Scanner(System.in);
        nombre = sc.nextInt();
        return nombre;
    }
}
