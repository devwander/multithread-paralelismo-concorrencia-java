package executors;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executors_Scheduled2 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
    // executor.schedule(new Tarefa(), 2, TimeUnit.SECONDS);
    executor.scheduleAtFixedRate(new Tarefa(), 0, 2, TimeUnit.SECONDS);
  }

  public static class Tarefa implements Runnable {
    @Override
    public void run() {
      String name = Thread.currentThread().getName();
      int nextInt = new Random().nextInt(1000);
      System.out.println(name + ": Studying Executors - " + nextInt);
    }
  }
}
