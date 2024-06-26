import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueue_1 {
  private static final SynchronousQueue<String> FILA = new SynchronousQueue<>();

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();

    Runnable r1 = () -> {
      put();
      System.out.println("Escreveu na fila!");
    };

    Runnable r2 = () -> {
      String msg = take();
      System.out.println("Pegou da fila! " + msg);
    };

    executor.execute(r1);
    executor.execute(r2);

    executor.shutdown();
  }

  public static void put() {
    try {
      FILA.put("Novo...");
      // return FILA.offer();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static String take() {
    try {
      return FILA.take();
      // return FILA.poll();
      
    } catch (InterruptedException e) {
      e.printStackTrace();
      return "Error";
    }
  }
}