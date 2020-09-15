package diplo.tools;

import java.util.Scanner;

public class Tools {
     /**
     * Wait a delimited time before executing a lambda expression
     * This method is used in async using a new Thread
     * @param runnable lambda expression
     * @param delay time to wait in ms
     */
    public static void setTimeoutAsync(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
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
        int resultRandom = (int)Math.floor(Math.random() * 10001);
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
        TConsole.toprint("Une erreur est survenue, veuillez recommencer");
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
        TConsole.toprint("Une erreur est survenue, veuillez recommencer");
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
        TConsole.toprint("Une erreur est survenue, veuillez recommencer");
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
