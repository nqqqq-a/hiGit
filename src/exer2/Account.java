package exer2;

public class Account {
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * author:nq
     * 取钱
     * @param amount
     */
    public void withdraw(double amount){
        System.out.println("要取走金额:"+amount);
        if (balance >= amount){
            this.balance = this.balance - amount;
            System.out.println("账户剩余余额:"+balance);
            System.out.println("-------");
        } else {
            System.out.println("账户余额不够");
            System.out.println("账户余额为："+balance);
            System.out.println("-------");
        }
    }

    /**
     * author：nq
     * 存钱
     * @param amount
     */
    public void deposit(double amount){
        System.out.println("要存入的金额为:"+amount);
        balance = balance + amount;
        System.out.println("账户余额为："+balance);
        System.out.println("-------");
    }
}
