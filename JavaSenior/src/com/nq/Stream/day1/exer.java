package com.nq.Stream.day1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author Nq
 * @Data 2021-02-26-12:03
 */
public class exer {
    @Test
    public void test() throws IOException {
        File file = new File("hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：hi.txt
        File destFile = new File(file.getParent(),"hi.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile) System.out.println("创建成功");
        else destFile.delete();
    }
}
