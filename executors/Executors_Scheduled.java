package executors;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Executors_Scheduled {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
    ScheduledFuture<String> future = executor.schedule(new Tarefa(), 2, TimeUnit.SECONDS);
    System.out.println(future.get());
    executor.shutdown();
  }

  public static class Tarefa implements Callable<String> {
    @Override
    public String call() {
      String name = Thread.currentThread().getName();
      int nextInt = new Random().nextInt(1000);
      return (name + ": Studying Executors - " + nextInt);
    }
  }
}
