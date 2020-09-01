import java.util.Scanner;

public class PlusPetit {

    public static void main(String[] arg) {
        /***********************************/
        /*           VERSION 1             */
        /***********************************/

        int nombre1, nombresSuivants, plusPetit;

        nombre1 = print();

        plusPetit = nombre1;

        for(int i = 0; i < 4; i++) {
            nombresSuivants = print();
            if(nombresSuivants < plusPetit) {
                plusPetit = nombresSuivants;
            }
        }

        System.out.println("Le nombre le plus petit de la liste est le : " + plusPetit);

        /***********************************/
        /*           VERSION 2             */
        /***********************************/

        //int nombre1, nombre2, nombre3, nombre4, nombre5, plusPetit;

        /*nombre2 = print();

        if(nombre2 < plusPetit) {
            plusPetit = nombre2;
        }

        nombre3 = print();

        if(nombre3 < plusPetit) {
            plusPetit = nombre3;
        }

        nombre4 = print();

        if(nombre4 < plusPetit) {
            plusPetit = nombre4;
        }

        nombre5 = print();

        if(nombre5 < plusPetit) {
            plusPetit = nombre5;
        }

        System.out.println("Le nombre le plus petit de la liste est le : " + plusPetit);*/

    }

    public static int print() {
        int nombre;
        System.out.println("Veuillez saisir un entier");
        Scanner sc = new Scanner(System.in);
        nombre = sc.nextInt();
        return nombre;
    }
}
