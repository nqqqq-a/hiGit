package exer2;

public class Bank {
    private Customer[] customers; //存放多个客户的数组
    private int numberOfCustomer; //记录客户的个数 = 数组的长度-1

    public Bank() {
        customers = new Customer[10];
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    /**
     * 添加客户
     * @param firstname
     * @param lastname
     */
    public void addCustomer(String firstname,String lastname){
        Customer customer = new Customer(firstname,lastname);
        customers[numberOfCustomer++] = customer;
    }

    //获取指定位置的客户
    public  Customer getCustomer(int index){
        if (index >= 0 && index < numberOfCustomer){
            return customers[index];
        }else{
            System.out.println("越界了");
            return null;
        }

    }

}
