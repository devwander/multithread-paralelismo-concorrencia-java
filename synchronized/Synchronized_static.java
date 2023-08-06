public class Synchronized_static {

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

    // Synchronized em código estático 
    public static void imprime() {
        synchronized(Synchronized_static.class) {
            i++;
            String name = Thread.currentThread().getName();
            System.out.println(name + " : " + i);
        }
    }

    public static class MeuRunnable implements Runnable {
        public void run() {
            imprime();
        }
    }
}
