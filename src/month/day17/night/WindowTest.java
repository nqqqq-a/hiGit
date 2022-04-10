package month.day17.night;

/**
 * @Author Nq
 * @Data 2021-01-17-20:20
 */

class window extends Thread{

    private static int ticket = 100; //票数
    public void run(){

        while(true){
            if (ticket > 0) {
                System.out.println(getName() + ": 卖票,票号为:" + ticket);
                ticket--;
            }else break;
        }

    }

}

public class WindowTest {
    public static void main(String[] args) {
        window w1 = new window();
        window w2 = new window();
        window w3 = new window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
