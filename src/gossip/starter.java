package gossip;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class starter {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer,Double> hashMap = new ConcurrentHashMap<Integer,Double>();
        hashMap.put(-1,0.0);


        //参数指定：k = 8, n = 25
        Node.setK(8);
        int n = 25;



        double valuesum = 0.00;
        Node[] Nodes=  new Node[n];
        CountDownLatch latch = new CountDownLatch(n);


        for (int i = 0; i < n; i++) {
            Nodes[i] =  new Node(true,1.0,i,hashMap,n);
            Nodes[i].latch = latch;
            Nodes[i].start();
            double value = (int) (Math.random()*100);
            valuesum += value;
            hashMap.put(i, value);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println();



        System.out.println("节点数："+n);

        System.out.println("执行轮数:"+hashMap.get(-1));

        System.out.println("误差：" + Math.abs(valuesum/n-hashMap.get(1)));



    }
}
