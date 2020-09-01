import java.util.Scanner;

public class Somme {
    public static void main(String[] arg0) {
        int number, somme = 0;
        System.out.println("Veuillez saisir un entier");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        for(int i = 1; i < (number+1); i++) {
            somme = somme + i;
        }
        System.out.println(somme);
    }
}
