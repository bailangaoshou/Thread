package syn;

public class unsafeTicket {

    public static void main(String[] args) {
        buyTicket buyticket = new buyTicket();
        new Thread(buyticket,"小明").start();
        new Thread(buyticket,"小红").start();
    }

}

class  buyTicket implements Runnable{

    private  int tickets = 10;
    private  boolean flag = true;
    @Override
    public  void run() {

        while (flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buy();
        }
    }

    private   void  buy(){
        synchronized ((Integer)tickets){
            if (tickets>0){
                System.out.println(Thread.currentThread().getName()+"get"+tickets--);
            }
            else {
                flag = false;
            }
        }

    }
}
