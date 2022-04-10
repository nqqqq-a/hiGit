package exer1;

public class Check {
    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1122,20000,0.045,5000);

        checkAccount.withdraw(5000);
        System.out.println("您的账户余额："+checkAccount.getBalance());
        System.out.println("可透支额度："+checkAccount.getOverdraft());
        System.out.println("*************");

        checkAccount.withdraw(18000);
        System.out.println("您的账户余额："+checkAccount.getBalance());
        System.out.println("可透支额度："+checkAccount.getOverdraft());
        System.out.println("*************");

        checkAccount.withdraw(3000);
        System.out.println("您的账户余额："+checkAccount.getBalance());
        System.out.println("可透支额度："+checkAccount.getOverdraft());
    
    }
}
