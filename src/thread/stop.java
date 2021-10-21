package thread;


//建议线程正常停止
/*
不建议死循环
建议使用标志位
不要使用stop或destroy

*/

public class stop implements Runnable{
    private  boolean flag = true;

    @Override
    public void run() {
        int i = 0;

        while (flag){
            System.out.println("线程运行中"+i++);
        }
    }
    public  void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {

        stop s = new stop();
        new Thread(s).start();

        for (int i = 0; i < 100; i++) {
            if (i==90)
            {
               s.stop();
            }
            System.out.println("main"+i);
        }
    }
}
