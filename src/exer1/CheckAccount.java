package exer1;

public class CheckAccount extends Account {
    private double overdraft; //可透支限额

    public CheckAccount(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckAccount(int id, double balance, double annuallnterestRate, double overdraft) {
        super(id, balance, annuallnterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= super.getBalance()){
            super.withdraw(amount);
        }
        if (amount > super.getBalance()){
            double needoverdraft = amount - super.getBalance();
            System.out.println("需要透支余额:"+needoverdraft);
            if (overdraft >= needoverdraft){
                super.setBalance(0); //钱不够 要透支额度
                overdraft -= needoverdraft ;
                System.out.println("账户余额："+getBalance()+"可透余额"+overdraft);

            }else {
                System.out.println("超过可透支限额");
                System.out.println("账户余额："+getBalance()+"可透余额"+overdraft);
            }
        }
    }
}
