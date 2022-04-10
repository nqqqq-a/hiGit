package com.nq.newp2.service;

import com.nq.newp2.bean.Customer;

public class CustomerList {
    private Customer[] customers;
    private int total = 0; //用户总数

    public CustomerList(int totalnumber) {
        customers = new Customer[totalnumber];
    }

    public boolean addCustomer(Customer customer){
        if (total >= customers.length){
            System.out.println("客户数量已经满");
            return false;
        }else {
            customers[total++] = customer;
            return true;
        }
    }

    public boolean replaceCustomer(int index,Customer cust) {
        if (index < 0 || index >= total) {
            System.out.println("指定客户不存在");
            return false;
        }else {
            customers[index] = cust;
            return true;
        }
    }

    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total){
            return false;
        }else {
            for (int i = index;i < total - 1;i++){
                customers[i] = customers[i+1];
            }
            customers[--total] = null;
            return true;
        }
    }

    public Customer[] getAllCustomer(){
        Customer[] newcustomers = new Customer[total];
        for (int i = 0;i <= total - 1;i++){
            newcustomers[i] = customers[i];
        }
        return newcustomers;
    }

    public Customer getCustomer(int index){
        if (index < 0 || index >= total) {
            System.out.println("指定客户不存在");
            return null;
        }else {
            return customers[index];
        }
    }

    public int getTotal(){
        return total;
    }
}
