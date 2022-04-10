package com.nq.inheritance;

public class Kids extends Mankind {
    private int yearsOld;

    public Kids() {
        super();
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println(yearsOld);
    }

    @Override
    public void emplyeed() {
//        super.emplyeed();

    }
}
