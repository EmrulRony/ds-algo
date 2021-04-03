package others.thread.it_communicate;

public class THreadA {
    public static void main(String[] args) throws InterruptedException {
        ThreadB tb = new ThreadB();
        Thread t = new Thread(tb);
        t.start();
        synchronized (t){
            for (int i= 0 ; i <= 10 ; i++){
                System.out.println("Main Thread... ");
                t.wait();
            }
        }
    }
}
