package threads;

public class Threads_1 {
    public static void main(String[] args) {
        // Thread atual
        Thread t = Thread.currentThread();
        System.out.println(t.getName());

        // Nova thread
        Thread t1 = new Thread(new MeuRunnable());
        // t1.run(); // executando na mesma thread
        
        // Runnable como lambda
        Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " - Lutando até o fim."));
        // t2.start(); // Não faça! Será lançar uma exceção
        
        // Várias threads
        Thread t3 = new Thread(new MeuRunnable());
        
        t1.start(); // executando em uma nova thread
        t2.start();
        t3.start();
    }
}