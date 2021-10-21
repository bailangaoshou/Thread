package thread;

public class test {


    public static void main(String[] args) {

        thread t = new thread();
        // t.start();   start:主线程和子线程并行交替执行
        // t.run();     run：主线程等待子线程执行完毕后再执行
         t.start();
        for (int i=0;i<100;i++)
        {
            System.out.println("hot-fix");
            System.out.println("github test");
            // work 01 finished
        }
    }
}
