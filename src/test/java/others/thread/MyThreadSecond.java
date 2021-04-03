package others.thread;

public class MyThreadSecond implements Runnable{
    static Thread mt;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("Second Child thread...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
