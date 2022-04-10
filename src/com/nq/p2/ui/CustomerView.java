package com.nq.p2.ui;

import com.nq.p2.bean.Customer;
import com.nq.p2.service.CustomerList;
import com.nq.p2.util.CMUtility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    /**
     *用户进入的界面《客户信息管理软件》界面
     */
    public void enterMainMenu(){
        boolean isFlage = true;
        while (isFlage) {
            System.out.println("------------客户信息管理软件------------");
            System.out.println("            1  添 加 客 户               ");
            System.out.println("            2  修 改 客 户               ");
            System.out.println("            3  删 除 客 户               ");
            System.out.println("            4  客 户 列 表               ");
            System.out.println("            5   退   出                 ");
            System.out.println("       请选择(1-5):");
            switch (CMUtility.readMenuSelection()){
                case '1' :
                    addNewCustomer();
                    break;
                case '2' :
                    modifyCustomer();
                    break;
                case '3' :
                    deleteCustomer();
                    break;
                case '4' :
                    listAllCustomers();
                    break;
                case '5' :
                    System.out.print("是否确定退出(Y/N):");
                    if (CMUtility.readConfirmSelection() == 'Y'){
                        isFlage = false;
                        System.out.println("成功退出");
                    }
                    break;
            }

        }

    }

    /**
     * 添加客户的操作
     */
    private void addNewCustomer(){
        System.out.println("----------------添加客户------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别: ");
        char sex = CMUtility.readChar();
        System.out.print("年龄: ");
        int age = CMUtility.readInt();
        System.out.print("电话: ");
        String phone = CMUtility.readString(11);
        System.out.print("邮箱: ");
        String email = CMUtility.readString(30);
        Customer customer = new Customer(name,sex,age,phone,email);

        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess){
            System.out.println("添加完成");
        }else {
            System.out.println("用户已满，添加失败");
        }

    }

    /**
     * 修改客户的操作
     */
    private void modifyCustomer(){

        for (;;){

            System.out.print("请输入要修改的客户编号(-1退出)：");
            int number = CMUtility.readInt();
            Customer cust= customerList.getCustomer(number-1);
            if ( number == -1 ){
                return;
            }else if (cust  == null){
                System.out.println("无法找到指定客户");
            }else { //找到客户，开始修改操作
                System.out.print("姓名(" + cust.getName() +"):");
                String name = CMUtility.readString(10, cust.getName());

                System.out.print("性别(" + cust.getSex() + "):");
                char sex = CMUtility.readChar(cust.getSex());

                System.out.print("年龄(" + cust.getAge() + "):");
                int age = CMUtility.readInt(cust.getAge());

                System.out.print("电话(" + cust.getPhone() + "):");
                String phone = CMUtility.readString(11, cust.getPhone());

                System.out.print("邮箱(" + cust.getEmail() + "):");
                String email = CMUtility.readString(30, cust.getEmail());

                Customer customer = new Customer(name,sex,age,phone,email);
                boolean isSucess = customerList.replaceCustomer(number-1,customer);
                if (isSucess){
                    System.out.println("修改成功");
                }else {
                    System.out.println("修改失败");
                }
                break;
            }
        }
    }

    /**
     * 删除客户的操作
     */
    private void deleteCustomer(){
        for (;;){
            System.out.println("请输入要删除的客户编号(-1退出):");
            int number = CMUtility.readInt();
            Customer customer = customerList.getCustomer(number - 1);
            if (number == -1) {
                return;
            }else if (customer == null) {
                System.out.println("找不到客户");
                continue;
            }else {
                customerList.deleteCustomer(number - 1);
                break;
            }
        }
    }

    /**
     * 展示客户列表的操作
     */
    private void listAllCustomers(){
        System.out.println("-------------------客户列表------------------");
        if (customerList.getTotal() == 0){
            System.out.println("没有客户记录!");
        }else {
            System.out.println("编号\t姓名\t\t性别\t年龄\t电话\t\t邮箱");
            Customer[] allCustomers = customerList.getAllCustomers();
            for (int i = 0; i < allCustomers.length;i++){
                Customer cust = allCustomers[i];
                System.out.println((i+1) + "\t" + cust.getName() + "\t" + cust.getSex()
                                    + "\t" + cust.getAge() + "\t" +cust.getPhone() + "\t" + cust.getEmail());
            }
        }

        System.out.println("-------------------客户列表完成------------------");
    }


    public static void main(String[] args) {
        CustomerView cv = new CustomerView();
        cv.enterMainMenu();
    }
}
