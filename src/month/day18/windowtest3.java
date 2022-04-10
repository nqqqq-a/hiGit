package month.day18;

/**
 * 使用同步方法解决时限Runnable接口的线程安全问题
 *
 *
 * @Author Nq
 * @Data 2021-01-18-10:06
 */
class window3 implements Runnable{

    private int ticket = 100;


    @Override
    public void run() {
        while (true){

                show();

        }

    }

    //将synchronized放在方法中
    private synchronized void show(){//同步监视器：this
//       放在内部，仍然是同步了代码块而已,synchronized (this){}
        if (ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket);
            ticket--;
        }
    }
}

public class windowtest3 {
    public static void main(String[] args) {
        window3 w = new window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
