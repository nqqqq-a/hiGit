package month.day18.exer;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000元，存3次，每次存完打印账户余额
  分析：
  1.是否有多线程问题？ 是，两个储户线程
  2.是否有共享数据？ 有，账户(账户余额)
  3.是否有线程安全问题？ 有
  4.需要考虑如何解决线程安全问题？ 同步机制：三种方式

 * @Author Nq
 * @Data 2021-01-18-21:50
 */
class Account{
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount){
        if (amount > 0){

            balance += amount;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }

}

class Customer extends Thread{

    private Account account;

    public Customer(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0;i < 3; i++){
            account.deposit(1000);
        }
    }
}

public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }

}
