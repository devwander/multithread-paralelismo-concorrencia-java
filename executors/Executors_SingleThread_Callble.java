package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Executors_SingThread_Callble {
  public static void main(String[] args) {
    ExecutorService executor = null;
    Future<?> future = null;
    try {
      executor = Executors.newSingleThreadExecutor();
      future = executor.submit(new Tarefa());
      // executor.execute(new Tarefa());
      executor.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (executor != null) {
        executor.shutdown();
        // executor.shutdownNow(); Parada abrupta
      }
      System.out.println(future.isDone());
    }
  }

  public static class Tarefa implements Runnable {
    @Override
    public void run() {
      String name = Thread.currentThread().getName();
      System.out.println(name + ": Studying Executors");
    }
  }
}