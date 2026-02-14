package multithreading;

public class ThreadTester {
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 =  new Thread1("thread1");
        System.out.println("Thread Is started");
        thread1.start();
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
        System.out.println("Thread Is Ends");
    }
}
