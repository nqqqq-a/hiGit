package month.day17;

/**
 * 多线程的创建: 方式一：继承与Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread的run()方法 -->将此相处执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.调用start()方法
 *
 * 例子: 遍历100以内的所有偶数
 *
 * @author Nq
 * @Data 2021-01-17-11:45
 */

//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread的run()方法

    public void run(){
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0 ){
                System.out.println(i + "是偶数");
            }
        }
        
    }


}
public class ThreadTest {

    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();

        //4.调用start()方法 ①启动当前进程 ② 调用当前线程的run()
        //问题一:我们不能直接调用run()启动线程，必须使用start()方法
        myThread.start();

        //问题二：在启动一个线程，遍历100以内的奇数,
        // 不可以还让start去执行，会报异常,
        // 只能重新新建一个对象
        MyThread myThread1 = new MyThread();
        myThread1.start();

        for (int i = 0;i < 100;i++){
            if (i % 2 == 0 ){
                System.out.println(i + "******main****");
            }
        }

    }
}



