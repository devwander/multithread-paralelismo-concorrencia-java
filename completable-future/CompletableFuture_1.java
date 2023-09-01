import java.util.concurrent.CompletableFuture;

public class CompletableFuture_1 {

  public static void main(String[] args) {
    CompletableFuture<String> processe = processe();

    CompletableFuture<String> thenApply = processe.thenApply(s -> s + " Primeiro!");

    thenApply.thenAccept(s -> System.out.println(s));

    System.out.println("Segundo!");

    sleep();
    sleep();
    sleep();
  }

  private static CompletableFuture<String> processe() {
    return CompletableFuture.supplyAsync(() -> {
      sleep();
      return "Processo!";
    });
  }

  private static final void sleep() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      e.printStackTrace();
    }
  }

}