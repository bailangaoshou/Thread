package thread;

public class Race implements Runnable{


    private  static  String winner; //Race类的静态属性，因此对于所有进程来说是共享的

    @Override
    public void run() {


        //方法内的变量是私有的
        for (int i = 0; i <= 100; i++) {
            boolean flag = isOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+ "跑了" + i + "步"  );
        }
    }

    private boolean isOver(int steps){
        if (winner!=null){
            return true;
        }
        else {
            if (steps>=100)
            {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is " + winner);
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"🐇").start();
        new Thread(race,"🐢").start();
    }
}
