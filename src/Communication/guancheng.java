package Communication;


//管程法

public class guancheng {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        productor p = new productor(buffer);
        Customer c = new Customer(buffer);

        p.start();
        c.start();
    }

}
//生产者
class productor extends Thread {

    private   Buffer buffer;
    private  int nextid = 0;
    public productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true)
        {
            buffer.put(new product(nextid++));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//消费者
class Customer extends  Thread{

    private   Buffer buffer;

    public Customer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true)
        {
            buffer.pop();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
//缓冲区
class  Buffer{

  private  product[] products = new product[10];
  int size = 0;


  public  synchronized  void  put(product p){
        if (size ==10)
        {
            System.out.println("缓冲区满！");
            //缓冲区满，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            products[size] = p;
            System.out.println("放入了" + p.getId() + "号产品");
            size++;
            this.notifyAll();
        }

  }
  public  synchronized  product  pop(){
      if (size==0){
          //缓冲区空，消费者等待
          System.out.println("缓冲区空！");
          try {
              this.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      else
      {
          size--;
          System.out.println("取出了" + products[size].getId() + "号产品");
          this.notifyAll();
          return products[size];

      }
      return null;


  }


}
//产品
class product{
    private   int id;

    public product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}


