package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLock_1 {
  private static int i = -1;
  private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();

    Runnable r1 = () -> {
      Lock writeLock = lock.writeLock();
      writeLock.lock();
      String name = Thread.currentThread().getName();
      System.out.println("writing - " + name + ": " + i);
      i++;
      System.out.println("written - " + name + ": " + i);
      writeLock.unlock();
    };

    Runnable r2 = () -> {
      Lock readLock = lock.readLock();
      readLock.lock();
      String name = Thread.currentThread().getName();
      System.out.println("reading - " + name + ": " + i);
      i++;
      System.out.println("read - " + name + ": " + i);
      readLock.unlock();
    };

    for (int i = 0; i < 6; i++) {
      executor.execute(r1);
      executor.execute(r2);
    }

    executor.shutdown();
  }
}
