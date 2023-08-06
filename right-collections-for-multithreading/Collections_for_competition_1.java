import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collections_for_competition_1 {

    // Coleções que são Thread-safe
    // CopyOnWriteArrayList - Indicada para quando a muita leitura e pouca inscrita
    private static List<String> lista = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(500);

        System.out.println(lista);
    }

    public static class MeuRunnable implements Runnable {
        public void run() {
            lista.add("String qualquer! 1");
            String name = Thread.currentThread().getName();
            System.out.println(name + " - inseriu na lista!");
        }
    }
}
