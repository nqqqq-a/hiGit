package month.day17.windowtest;

/**
 * @Author Nq
 * @Data 2021-01-17-20:38
 */

/*线程安全
 方法一：同步代码块
 synchronized(同步监视器){
    需要被同步的代码
  }
  说明：1.操作共享数据的代码，即为需要同步的代码
       2.共享数据：多个线程共同操作的变量。如：ticket
       3.同步监视器,俗称：锁。任何一个对象，都可以充当锁
            要求： 多个线程必须要共用同一把锁
*/
class window implements Runnable{

    private int ticket = 100;
    Object object = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (object){
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket);
                    ticket--;
                }else break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
public class windowtest1 {
    public static void main(String[] args) {
        window w1 = new window();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");

        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
