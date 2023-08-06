import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Collections_for_competition_3 {

    // Coleção Thread-safe
    // Sempre um pouco mais lenta
    private static BlockingQueue<String> fila = new LinkedBlockingQueue<>();
    // Outra alternativa: LinkedBlockingDeque
    // Neste caso elementos podem ser tirados do começo
    // e do final 

    public static void main(String[] args) throws InterruptedException {

        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(500);

        System.out.println(fila);

    }

    public static class MeuRunnable implements Runnable {
        @Override
        public void run() {
            fila.add("String qualquer 3!");
            String name = Thread.currentThread().getName();
            System.out.println(name + " - inseriu na lista!");
        }
    }
}
