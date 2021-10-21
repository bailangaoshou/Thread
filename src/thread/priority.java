package thread;

//线程优先级：1~10，数字越大，优先级越高
//主线程默认优先级为5
public class priority implements  Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        priority p = new priority();
        Thread t1 =   new Thread(p);
        Thread t2 =   new Thread(p);
        Thread t3 =   new Thread(p);
        Thread t4 =   new Thread(p);





        t1.start();
        t2.setPriority(4);
        t2.start();
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();
        t4.setPriority(2);
        t4.start();




    }

}


