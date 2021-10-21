package syn;

import java.util.concurrent.locks.ReentrantLock;

public class lock {
    public static void main(String[] args) {
        testlock testlock = new testlock();
        Thread t1 = new Thread(testlock);
        Thread t2 = new Thread(testlock);
        Thread t3 = new Thread(testlock);
        t1.start();
        t2.start();
        t3.start();
    }

}

class testlock implements Runnable{

    int num = 40;

    //定义锁
    private  final  ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

            while (true){
                try {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.lock();//加锁
                if (num>0){

                    System.out.println(Thread.currentThread().getName()+"get"+num--);

                }
                else {
                    break;
                }

                }finally {
                    lock.unlock();

                }


            }


    }
}
