package com.nq.java.day22;

/**
 * @Author Nq
 * @Data 2021-01-22-16:37
 */
public class Goods implements Comparable {

    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //指明商品比较大小的方式:按照价格从低到高排序,在按照产品名从低到高排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods = (Goods)o;
            if (this.price > goods.price){
                return 1;
            }else if (this.price < goods.price){
                return -1;
            }else return 0;
            //方法二 ： Double类里面的compare方法
//          return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入数据类型不一致");
    }
}
