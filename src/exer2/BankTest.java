package exer2;

import exer1.Account;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("Jane","Smith");

        bank.getCustomer(0).setAccount(new Account(1111,2000,0.0123));
        bank.getCustomer(0).getAccount().withdraw(500);
        double balance = bank.getCustomer(0).getAccount().getBalance();
        System.out.println("账户余额为:" + balance);
        System.out.println("----------");

        bank.addCustomer("n","q");
        System.out.println("银行客户的人数为："+ bank.getNumberOfCustomer());

    }
}
