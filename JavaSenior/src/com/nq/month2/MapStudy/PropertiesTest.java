package com.nq.month2.MapStudy;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Author Nq
 * @Data 2021-02-10-10:39
 */
public class PropertiesTest {

    //Properties：长用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis); //加载流对应的文件

        String name = (String) pros.get("name");
        System.out.println(name);
        Object password = pros.get("password");
        System.out.println(password);

        fis.close();
    }
}
