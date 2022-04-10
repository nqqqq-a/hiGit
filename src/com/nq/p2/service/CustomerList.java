package com.nq.p2.service;

import com.nq.p2.bean.Customer;

/**
 * CRUD
 */
public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    /**
     * 用来初始化customers数组的构造器，
     * @param totalCustomer：代表数组的最大容量
     */
    public CustomerList(int totalCustomer) {
         customers = new Customer[totalCustomer];
    }

    /**
     * 将指定客户添加到customers数组中
     * @param customer
     * @return true:添加成功 false:添加失败
     */
    public boolean addCustomer(Customer customer){
    if (total >= customers.length) {
        return false;
    }else {
        customers[total++] = customer;
        return true;
    }
}

    /**
     * 修改指定索引位置上的客户信息
     * @param index
     * @param customer
     * 修改成功:true 修改失败:false
     */
    public boolean replaceCustomer(int index,Customer customer){
        if (index < 0 || index >= total ){
            return false;
        }else {
            this.customers[index] = customer;
            return true;
        }

    }

    /**
     * 删除指定索引位置上的客户信息
     * @param index
     * @return true: 修改成功 false:修改失败
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total ){
            return false;
        }else {
            for (int i = index;i < total - 1;i++){
                 customers[i] = customers[i + 1];
            }
            customers[--total] = null;
            return true;
        }
    }

    /**
     * 获取所有的客户信息
     * @return cust获取的都是地址值
     */
    public Customer[] getAllCustomers(){
        Customer[] cust = new Customer[total];
        for (int i= 0; i < total; i++) {
            cust[i] = customers[i];
        }
        return cust;
    }

    /**
     * 获取指定索引位置上的客户信息
     * @param index
     * @return 如果找到了元素，返回该客户信息，否则返回null
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total ){
            return null;
        }else return customers[index];
    }

    /**
     * 获取客户数量
     * @return 数量
     */
    public int getTotal(){
        return total;
    }
}
