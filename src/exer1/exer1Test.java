package exer1;

public class exer1Test {
    public static void main(String[] args) {
        Account acct = new Account(1122,20000,0.045);

        acct.withdraw(30000);
        acct.withdraw(2500);
        acct.deposit(3000);

        System.out.println("月利率为："+acct.getMonthlyInterest() * 100 +"%");
    }

}
