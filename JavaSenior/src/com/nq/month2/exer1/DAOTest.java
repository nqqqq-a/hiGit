package com.nq.month2.exer1;

import java.util.List;

/**
 * @Author Nq
 * @Data 2021-02-23-22:38
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User("周杰伦",1001,34));
        dao.save("1002",new User("昆凌",1002,20));
        dao.save("1003",new User("蔡依林",1003,25));

        dao.update("1003",new User("方文山",1003,30));

        dao.delete("1002");
        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);


    }

}
