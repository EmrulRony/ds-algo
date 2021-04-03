package others.thread;

public class MyThread implements Runnable{
    static Thread mt;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("Child thread...");
        }
    }
}
