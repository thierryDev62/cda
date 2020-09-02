public class CompteARebours {
    public static void main(String[] arg) {
        int secondes = 60;
        while(secondes > 0) {
            int finalNombreMax = secondes;
            setTimeoutSync(() -> System.out.println(finalNombreMax), 1000);
            secondes--;
        }
        System.out.println("Fini !");
    }

    public static void setTimeoutSync(Runnable runnable, int delay) {
        try {
            Thread.sleep(delay);
            runnable.run();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
