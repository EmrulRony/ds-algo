package others.thread.it_communicate;

public class ThreadB implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0 ; i <= 10 ; i++){
                System.out.println("Child Thread");
                if (i > 5){
                    this.notify();
                }
            }
        }
    }
}
