import java.util.Scanner;

public class Tools {
    /**
     * Show a string
     * @param toPrint
     */
    public static void toprint(String toPrint) {
        System.out.print(toPrint);
    }
    /**
     * Show an integer
     */
    public static void toprint(int intPrint) {
        System.out.print(String.valueOf(intPrint));
    }
    /**
     * Show a string
     * @param toPrint
     */
    public static void toprintln(String toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Show an integer
     */
    public static void toprintln(int intPrint) {
        System.out.println(String.valueOf(intPrint));
    }

    /**
     * Show an float
     */
    public static void toprintln(float intPrint) {
        System.out.println(String.valueOf(intPrint));
    }

    /**
     * setTimeoutSync(() -> System.out.println(param), 1000);
     * @param runnable
     * @param delay
     */
    public static void setTimeoutSync(Runnable runnable, int delay) {
        try {
            Thread.sleep(delay);
            runnable.run();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * Random integer
     * @return
     */
    public static int intRandom() {
        int resultRandom = (int)Math.floor(Math.random() * 101);
        return resultRandom;
    }

    /**
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact *=  i;
        }
        return fact;
    }

    /**
     *
     * @return
     */
    public static String askThing() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    /**
     *
     * @param intWanted
     * @return
     */
    public static int askThing(int intWanted) {
        Scanner sc = new Scanner(System.in);
        String rep = sc.next();
        if(isInteger(rep)) {
            return Integer.parseInt(rep);
        }
        Tools.toprint("Une erreur est survenue, veuillez recommencer");
        return Tools.askThing(intWanted);
    }
    /**
     *
     * @param floatWanted
     * @return
     */
    public static float askThing(float floatWanted) {
        Scanner sc = new Scanner(System.in);
        String rep = sc.next();
        if(isFloat(rep)) {
            return Float.parseFloat(rep);
        }
        Tools.toprint("Une erreur est survenue, veuillez recommencer");
        return Tools.askThing(floatWanted);
    }

    /**
     *
     * @param doubleWanted
     * @return
     */
    public static double askThing(double doubleWanted) {
        Scanner sc = new Scanner(System.in);
        String rep = sc.next();
        if(isDouble(rep)) {
            return Double.parseDouble(rep);
        }
        Tools.toprint("Une erreur est survenue, veuillez recommencer");
        return Tools.askThing(doubleWanted);
    }

    /**
     *
     * @param test
     * @return
     */
    public static Boolean isInteger(String test){
        try {
            Integer.parseInt(test);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     *
     * @param test
     * @return
     */
    public static Boolean isFloat(String test){
        try {
            Float.parseFloat(test);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    /**
     *
     * @param test
     * @return
     */
    public static Boolean isDouble(String test){
        try {
            Double.parseDouble(test);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
