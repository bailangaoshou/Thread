package thread;

//线程插队
public class join implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("vip"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        join join = new join();
       Thread thread =  new Thread(join);
       thread.start();

        for (int i = 0; i < 100; i++) {
            if (i==50)
            {
                thread.join();
            }
            System.out.println("main"+i);
        }


    }

}
