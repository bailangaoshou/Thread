package thread;

public class thread extends Thread {

    @Override
    public void run() {
       //run
        for (int i=0;i<50;i++)
        {
            System.out.println("run");
        }
    }


    public static void main(String[] args) {
        //main
        thread t = new thread();
       // t.start();   start:主线程和子线程并行交替执行
       // t.run();     run：主线程等待子线程执行完毕后再执行
        t.run();
        for (int i=0;i<100;i++)
        {
            System.out.println("main");
        }

    }


}
