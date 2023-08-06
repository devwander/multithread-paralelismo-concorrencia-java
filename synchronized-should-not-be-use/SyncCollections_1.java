import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncCollections_1 {

    private static List<String> lista = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {

        lista = Collections.synchronizedList(lista);

        // Utilizar a versão do synchronizedXXX de acordo com o tipo de coleção
        // lista = Collections.synchronizedCollection(lista);
        // lista = Collections.synchronizedMap(lista);
        // lista = Collections.synchronizedSet(lista);

        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(250);

        System.out.println(lista);
    }

    public static class MeuRunnable implements Runnable {
        public void run() {
            lista.add("String qualquer!");
            String name = Thread.currentThread().getName();
            System.out.println(name + " - inseriu na lista!");
        }
    }
}