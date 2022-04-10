package month.day18;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @Author Nq
 * @Data 2021-01-18-10:18
 */
public class BankTest {

}

class Bank {
    private Bank(){}

    private static Bank instance = null;

    public static synchronized Bank getInstance(){
        //方式一：synchronized(Bank.class){}
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }
    /*方法二 效率更高
    if(instance == null) {
        synchronized(Bank.class){
        if (instance == null){
                instance = new Bank();
            }

           }

        }
            return instance;


     */
}
