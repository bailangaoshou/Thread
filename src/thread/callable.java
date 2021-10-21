package thread;

import java.util.concurrent.*;

public class callable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(1);//创建线程池

        callable callable = new callable();

        Future<String> result = service.submit(callable);  //提交执行
        //Future就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果。
        // 必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果。
        //　Future类位于java.util.concurrent包下，它是一个接口：
        String resultstr = result.get();  //获取结果

        System.out.println(resultstr);

        service.shutdownNow();
    }
}
