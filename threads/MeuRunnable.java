package threads;

public class MeuRunnable implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
