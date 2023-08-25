package executors;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executors_Scheduled3 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
    // executor.schedule(new Tarefa(), 2, TimeUnit.SECONDS);
    executor.scheduleWithFixedDelay(new Tarefa(), 0, 2, TimeUnit.SECONDS);
  }

  public static class Tarefa implements Runnable {
    @Override
    public void run() {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(LocalTime.now());
      String name = Thread.currentThread().getName();
      int nextInt = new Random().nextInt(1000);
      System.out.println(name + ": Studying Executors - " + nextInt);
    }
  }
}
