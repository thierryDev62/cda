package diplo.tools;

public class TSetTimeOut {
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
}
