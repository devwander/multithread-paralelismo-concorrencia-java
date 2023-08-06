import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Collections_for_competition_2 {

    // Coleção Thread-safe
    // Sempre um pouco mais lenta
    private static Map<Integer, String> mapa = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(500);

        System.out.println(mapa);
    }

    public static class MeuRunnable implements Runnable {
        @Override
        public void run() {
            int randomNum = new Random().nextInt();
            mapa.put(randomNum, "String qualquer 2!");
            String name = Thread.currentThread().getName();
            System.out.println(name + " - inseriu na lista!");
        }
    }
}
