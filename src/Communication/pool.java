package Communication;

public class pool {

}

class  testpool implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
