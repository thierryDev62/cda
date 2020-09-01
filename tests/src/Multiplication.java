import java.util.Scanner;

public class Multiplication {
    public static void main(String[] arg0) {
        int number;
        System.out.println("Veuillez saisir un entier");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        for(int i = 0; i < 11; i++) {
            System.out.println(i + "X" + number + "=" + i * number);
        }
    }
}
