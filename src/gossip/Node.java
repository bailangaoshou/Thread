package gossip;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class Node extends Thread{
    //每次概率降低的系数
    private  static  int k;
    //是否能进行传播，true表示能够继续传播，代表感染状态，false表示不能继续传播，代表已隔离
    private  boolean isactive;
    //进行传播的概率
    private  double p;
    //
    private int id;
    //
    private ConcurrentHashMap<Integer,Double> values;
    //
    private int n;

    private int flag =0;

    public CountDownLatch latch;


    public Node(boolean isactive, double p, int id, ConcurrentHashMap<Integer, Double> values,int n) {
        this.isactive = isactive;
        this.p = p;
        this.id = id;
        this.values = values;
        this.n = n;
    }

    public static  void  setK(int k){
        Node.k= k;
    }


    @Override
    public void run() {

        while (isactive){

            if (Math.random()<=p)
            {
                int q = (int)( Math.random()*n );

//                System.out.println("q = "+q);
                if (values.containsKey(q) && q!=id )
                {

                    if (similar(values.get(q),values.get(id)))
                    {
                        p = p / k;
                    }
                    else {
                        double newvalue = (values.get(q)+ values.get(id))/2.0;
                        values.put(q,newvalue);
                        values.put(id,newvalue);
                    }
                    flag ++ ;

                }



                if (p<=0.01)
                {
                    this.isactive = false;
                    this.p = 0.00;
                  System.out.println(id+":"+values.get(id));
                    values.put(-1,values.get(-1)+flag);
                    latch.countDown();

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public  boolean similar(double x,double y){
        if (Math.abs((x-y)) <=0.005)
        {
           return true;
        }
        return false;
    }


}
