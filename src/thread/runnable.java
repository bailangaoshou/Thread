package thread;

public class runnable implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<50;i++)
        {
            System.out.println("run");
        }
    }

    public static void main(String[] args) {
        runnable r = new runnable();
      //  r.run();

        new Thread(r).start();

        for (int i=0;i<100;i++)
        {
            System.out.println("main");
        }
    }
}
