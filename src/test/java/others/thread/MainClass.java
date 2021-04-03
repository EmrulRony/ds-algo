package others.thread;

public class MainClass {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        MyThreadSecond mt2 = new MyThreadSecond();
        Thread thread = new Thread(mt);
        Thread thread1 = new Thread(mt2);
        thread.start();
        thread1.start();

        for (int i = 0; i < 10; i++){
            System.out.println("Main thread...");
        }
    }
}
