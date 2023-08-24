package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Executors_MultiThread2 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService executor = null;
    try {
      executor = Executors.newCachedThreadPool();

      List<Tarefa> lista = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        lista.add(new Tarefa());
      }

      List<Future<String>> list = executor.invokeAll(lista);
      // String string = executor.invokeAny(lista); Retorna a mais rápida

      for (Future<String> future : list) {
        System.out.println(future.get());
      }

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