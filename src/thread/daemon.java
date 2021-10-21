package thread;


//守护线程
public class daemon {

    public static void main(String[] args) {
        me me = new me();
        you you = new you();

        Thread thread = new Thread(me);
        thread.setDaemon(true);//默认值为false，表示用户线程，为true时表示守护线程

        thread.start();

        new Thread(you).start();

    }
}


class  you implements  Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("你活着的第"+(i+1)+"年");
        }

        System.out.println("good bye,world");
    }
}

class  me implements Runnable {

    @Override
    public void run() {
        System.out.print("战斗开始了，");
        while (true){
            System.out.println("众神保佑你");
        }
    }
}