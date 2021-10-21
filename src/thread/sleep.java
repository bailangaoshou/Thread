package thread;


import java.text.SimpleDateFormat;
import java.util.Date;

//模拟网络延时
public class sleep implements  Runnable{


    @Override
    public void run() {
        int time = 5;
        System.out.println("倒计时开始");
        for (int i = 0; i < time; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(time-i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("倒计时结束");
    }
    public static void main(String[] args) {
//        sleep sleep = new sleep();
//        new Thread(sleep).start();

        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


