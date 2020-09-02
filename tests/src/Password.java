import java.util.Scanner;

public class Password {
    public static void main(String[] arg) {
        String motDePasseSaisi, motDePasseCorrect = "Bonjour", secret = "Minou", derniereChance;
        int tentatives = 3;
        for(int i = 0; i < 3; i++) {
            System.out.println("Veuillez saisir un mot de passe (3 tentatives permises)");
            Scanner sc = new Scanner(System.in);
            motDePasseSaisi = sc.next();
            if (motDePasseSaisi.equals(motDePasseCorrect)) {
                System.out.println("Vous êtes connecté !");
                break;
            } else {
                tentatives--;
                System.out.println("Mauvais mot de passe, il vous reste " + tentatives + " tantatives");
                if(tentatives == 0) {
                    System.out.println("Vous avez utilisé toutes vos tentatives, vous avez encore une chance avec le mot secret");
                    Scanner chance = new Scanner(System.in);
                    derniereChance = chance.next();
                    if(derniereChance.equals(secret)) {
                        System.out.println("Vous êtes connecté !");
                    } else {
                        System.out.println("Votre compte a été bloqué");
                    }
                }
            }
        }
    }
}
