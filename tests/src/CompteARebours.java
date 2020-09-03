public class CompteARebours {
    public static void main(String[] arg) {
        int secondes = 60;
        while(secondes > 0) {
            int finalNombreMax = secondes;
            Tools.setTimeoutSync(() -> System.out.println(finalNombreMax), 1000);
            secondes--;
        }
        System.out.println("Fini !");
    }
}
