package com.nq.month.day19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程的方式四：线程池
 *
 *面试题:创建多线程几种方式？ 四种！
 * @Author Nq
 * @Data 2021-01-19-9:57
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public  void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)executorService;
        //设置线程池的属性   转换为ThreadPoolExecutor类
        service1.setCorePoolSize(15); //核心池大小
        service1.setKeepAliveTime(5, TimeUnit.DAYS);  //线程没有任务时都保持多长时间会终止
        service1.setMaximumPoolSize(5); //最大线程数

        executorService.execute(new NumberThread()); //使用使用Runnable

        executorService.submit(new NumberThread1());  //适合适用于Callable
        //关闭连接池
        executorService.shutdown();

    }

}
