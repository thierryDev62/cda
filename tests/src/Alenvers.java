import java.util.Scanner;

public class Alenvers {
    public static void main(String[] arg) {
        int nombre, reversed = 0;

        System.out.println("Veuillez saisir un entier");
        Scanner sc = new Scanner(System.in);
        nombre = sc.nextInt();
        while(nombre != 0) {
            int digit = nombre % 10;
            System.out.println("Résultat modulo : " + digit);
            reversed = reversed * 10 + digit;
            System.out.println("Résultat inverse : " + reversed);
            nombre /= 10;
        }
        System.out.println("Numéro inversé : " + reversed);
    }
}
