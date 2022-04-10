package com.nq.month.day18;

/**
 * 线程通信的例子：使用两个线程打印1-100，线程1，线程2，交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法,就会唤醒被wait的一个线程，
 如果有多个线程被wait，就唤醒优先级高的
 * notifyAll():唤醒所有被wait的线程
 *
 * 说明:
 * 1.wait()，notify(),notifyAll三个方法必须使用在同步代码块或者同步方法中。
 * 2.wait()，notify(),notifyAll三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
        否则会出现异常。

 * 面试题：sleep()和wait()异同?
 * 1.相同点:一旦执行方法，都可以使得当前进程进入阻塞状态
 * 2.不同点：
        1）两个方法声明位置不一致，sleep()是Thread类中的静态，wait()声明在Object类中的final
        2）调用的要求不同：sleep()方法可以在任何需要的场景下调用。 wait()必须使用在同步代码块或者同步方法中。
        3）sleep()不释放锁且会自动醒来，wait()会释放锁，且需要被唤醒
 * @Author Nq
 * @Data 2021-01-18-22:40
 */

class Number implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){

                notify();

                if (number <= 100){

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else break;
            }

        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
