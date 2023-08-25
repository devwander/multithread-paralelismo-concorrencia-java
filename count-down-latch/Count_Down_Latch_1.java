import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Count_Down_Latch_1 {
  private static volatile int i = 0;
  private static CountDownLatch latch = new CountDownLatch(3); 

  public static void main(String[] args) throws InterruptedException {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
    
    Runnable r1 = () -> {
      int j = new Random().nextInt(1000);
      int x = i + j;
      System.out.println(i + " + " + j + " = " + x);
      latch.countDown();
    };

    executor.scheduleAtFixedRate(r1, 0, 1, TimeUnit.SECONDS);

    while (true) {
      latch.await();
      i = new Random().nextInt(1000);
      latch = new CountDownLatch(3);
    }
  }
}
