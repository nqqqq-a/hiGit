package exer1;

public class Account {
    private int id;//账户
    private double balance; //余额
    private double annuallnterestRate; //年利率

    //无参构造器
    public Account() {
    }

    //全参构造器
    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
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
            System.out.println("账户余额不足");
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

    /**
     * 返回月利率:即 年利率/12
     * @return 月利率：年利率/12
     */
    public double getMonthlyInterest(){
        return  annuallnterestRate / 12 ;
    }

}
