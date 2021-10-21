package thread;

public class yield  implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"End");
    }

    public static void main(String[] args) {
        yield y = new yield();
        new Thread(y,"A").start();
        new Thread(y,"B").start();
    }
}


