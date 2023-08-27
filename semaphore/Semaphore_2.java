package semaphore;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Semaphore_2 {
  private static final Semaphore SEMAPHORE = new Semaphore(100);
  private static final AtomicInteger counter = new AtomicInteger(0);

  public static void main(String[] args) {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(501);

    Runnable r1 = () -> {
      String name = Thread.currentThread().getName();
      int user = new Random().nextInt(10000);

      boolean achieved = false;

      counter.incrementAndGet();

      while(!achieved) {
        achieved = tryAcquire();
      }

      counter.decrementAndGet();

      System.out.println("User: " + user + " - name: " + name);

      sleep();

      SEMAPHORE.release();

      if (counter.get() == 0) {
        executor.shutdown();
      }
    };

    Runnable r2 = () -> {
      System.out.println(counter.get());
    };

    for (int i = 0; i < 500; i++) {
      executor.execute(r1);
    }

    executor.scheduleWithFixedDelay(r2, 0, 100, TimeUnit.MILLISECONDS);
  }

  private static boolean tryAcquire() {
    try {
      return SEMAPHORE.tryAcquire(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return false;
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
