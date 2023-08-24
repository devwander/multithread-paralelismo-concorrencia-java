package executors;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Executors_MultiThread {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService executor = null;
    try {
      // executor = Executors.newFixedThreadPool(2); // Determinamos o número de
      // threads criadas
      executor = Executors.newCachedThreadPool(); // Cria threads por demanda e reutiliza as desoculpadas

      Future<String> f1 = executor.submit(new Tarefa());
      Future<String> f2 = executor.submit(new Tarefa());
      Future<String> f3 = executor.submit(new Tarefa());

      System.out.println(f1.get());
      System.out.println(f2.get());
      System.out.println(f3.get());
      executor.shutdown();
    } catch (Exception e) {
      throw e;
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