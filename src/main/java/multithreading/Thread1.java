package multithreading;

public class Thread1 extends Thread {
    public Thread1(String mess){
        super(mess);
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread is Running Name of the Thread is: " + Thread.currentThread().getName() + " " + i);
        }
    }

}
