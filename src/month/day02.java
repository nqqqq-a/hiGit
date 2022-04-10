package month;

public class day02 {
    public static void main(String[] args) {

        //嵌套循环训练1
        //*
        //**
        //***
        //****
        //*****
        for (int i = 1;i <= 5;i++){
            for (int j = i;j >=1;j--){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("---------");
        //嵌套循环训练2
        //*****
        //****
        //***
        //**
        //*
        for (int i = 1;i <= 5;i++){
            for (int j = 5;j >=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------");

        //嵌套循环训练3
        //*
        //**
        //***
        //****
        //*****
        //*****
        //****
        //***
        //**
        //*
        for (int i = 1;i <= 5;i++){
            for (int j = 5;j >=i;j--){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
