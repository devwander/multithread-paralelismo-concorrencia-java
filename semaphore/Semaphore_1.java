package semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semaphore_1 {
  private static final Semaphore SEMAPHORE = new Semaphore(3);

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();

    Runnable r1 = () -> {
      String name = Thread.currentThread().getName();
      int user = new Random().nextInt(10000);
      acquire();
      System.out.println("User: " + user + " - name: " + name);

      sleep();

      SEMAPHORE.release();
    };

    for (int i = 0; i < 500; i++) {
      executor.execute(r1);
    }

    executor.shutdown();
  }

  private static void acquire() {
    try {
      SEMAPHORE.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void sleep() {
    try {
      int time = new Random().nextInt(6);
      time++;
      Thread.sleep(1000 * time);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }
}
