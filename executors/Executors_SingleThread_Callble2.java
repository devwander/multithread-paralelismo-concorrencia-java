package executors;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Executors_SingThread_Callble2 {
  /**
   * @param args
   * @throws InterruptedException
   * @throws ExecutionException
   */
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService executor = null;

    try {
      executor = Executors.newSingleThreadExecutor();
      Future<String> future = executor.submit(new Tarefa());

      System.out.println(future.isDone());
      System.out.println(future.get());
      System.out.println(future.isDone());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (executor != null) {
        executor.shutdownNow();
      }
    }
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