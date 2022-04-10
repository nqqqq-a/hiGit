package month.day17.ThreadTest1;

/**
 * @Author Nq
 * @Data 2021-01-17-20:28
 */

class MThread implements Runnable{

    @Override
    public void run() {
     for (int i = 0;i<100;i++){
         if (i % 2 ==0){
             System.out.println(i);
         }
     }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {

        MThread mThread = new MThread();
        Thread thread = new Thread(mThread);
        thread.start();
    }
}
