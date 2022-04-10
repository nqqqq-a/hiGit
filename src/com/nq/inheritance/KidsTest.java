package com.nq.inheritance;

public class KidsTest {
    public static void main(String[] args) {
        Kids somekid = new Kids();
        somekid.setSex(1);
        somekid.setSalary(10000);
        somekid.setYearsOld(21);
//        somekid.sex = 1;
//        somekid.salary = 100;
        somekid.emplyeed();
//        somekid.yearsOld = 2;
        somekid.printAge();
        somekid.manOrWoman();

    }

}
