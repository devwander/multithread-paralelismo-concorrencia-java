public class Synchronized_1 {

    static int i = -1;

    public static void main(String[] args) {
        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static class MeuRunnable implements Runnable {
        // Synchronized em método
        // public synchronized void run() {
        // i++;
        // String name = Thread.currentThread().getName();
        // System.out.println(name + " : " + i);
        // }

        // Synchronized em bloco
        public void run() {
            synchronized(this) {
                i++;
                String name = Thread.currentThread().getName();
                System.out.println(name + " : " + i);
            }
        }
    }

    // Ex
    // public static class MeuRunnable implements Runnable {
    //     static Object lock1 = new Object();
    //     static Object lock2 = new Object();

    //     public void run() {
    //         synchronized(lock1) {
    //             i++;
    //             String name = Thread.currentThread().getName();
    //             System.out.println(name + " 1 : " + i);
    //         }
    //         synchronized(lock2) {
    //             i++;
    //             String name = Thread.currentThread().getName();
    //             System.out.println(name + " 2 : " + i);
    //         }
    //     }
    // }
}