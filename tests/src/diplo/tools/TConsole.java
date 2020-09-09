package diplo.tools;

import java.util.ArrayList;

public class TConsole {
    /**
     * Print a string
     * @param toPrint
     */
    public static void toprint(String toPrint) {
        System.out.print(toPrint);
    }
    /**
     * Print an integer
     * @param intPrint
     */
    public static void toprint(int intPrint) {
        System.out.print(intPrint);
    }
    /**
     * Print a float
     * @param floatPrint
     */
    public static void toprint(float floatPrint) {
        System.out.print(floatPrint);
    }

    /**
     * Print a double
     * @param doublePrint
     */
    public static void toprint(double doublePrint) {
        System.out.print(doublePrint);
    }
    /**
     * Print a boolean
     * @param booleanPrint
     */
    public static void toprint(boolean booleanPrint) {
        System.out.print(booleanPrint);
    }

    /**
     * Print a long integer
     * @param longPrint
     */
    public static void toprint(long longPrint) {
        System.out.print(longPrint);
    }

    /**
     * Print an array list
     * @param arrayPrint
     */
    public static void toprint(ArrayList arrayPrint) {
        for(Object item : arrayPrint) {
            System.out.print(item);
        }
    }
/*****************************************************************************************/
/************************************** PRINT WITH BREAK *********************************/
/*****************************************************************************************/
    /**
     * Print a string with break
     * @param toPrint
     */
    public static void toprintln(String toPrint) {
        System.out.println(toPrint);
    }

    /**
     * Print an integer with break
     * @param intPrint
     */
    public static void toprintln(int intPrint) {
        System.out.println(intPrint);
    }

    /**
     * Print a float with break
     * @param floatPrint
     */
    public static void toprintln(float floatPrint) {
        System.out.println(floatPrint);
    }

    /**
     * Print a double with a break
     * @param doublePrint
     */
    public static void toprintln(double doublePrint) {
        System.out.println(doublePrint);
    }
    /**
     * Print a boolean with break
     * @param booleanPrint
     */
    public static void toprintln(boolean booleanPrint) {
        System.out.println(booleanPrint);
    }
    /**
     * Print a long integer with break
     * @param longPrint
     */
    public static void toprintln(long longPrint) {
        System.out.println(longPrint);
    }
    /**
     * Print an array list with break
     * @param arrayPrint
     */
    public static void toprintln(ArrayList arrayPrint) {
        for(Object item : arrayPrint) {
            System.out.println(item);
        }
    }
}
