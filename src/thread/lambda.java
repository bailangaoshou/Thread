package thread;

public class lambda {

    public static void main(String[] args) {
        //内部类
        inter i = new impl();
        i.lambda();

        //局部内部类
        class  impl2 implements  inter{
            @Override
            public void lambda() {
                System.out.println("success2");
            }
        }
        i = new impl2();
        i.lambda();
        //匿名内部类
        i = new inter() {
            @Override
            public void lambda() {
                System.out.println("success3");
            }
        };
        i.lambda();
        //lambda简化
        i = ()->{
            System.out.println("success4");
        };
        i.lambda();



    }
}

interface inter{
    void lambda();
}

class impl implements inter{
    @Override
    public void lambda() {
        System.out.println("success");
    }
}


