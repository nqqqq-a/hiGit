package com.nq.Stream.exer;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 练习3：获取文本上字符出现的此时，把数据写入文件
 *
 *
 * 思路：
 * 1.遍历文本每一个字符
 * 2.字符出现的次数存放在Map中
 *
 * Map<Character,Integer> map = new HashMap<>();
 * map.put('a',1);
 *
 * 3.把map中的数据写入文件
 *
 * @Author Nq
 * @Data 2021-03-06-11:22
 */
public class WordCount {
    @Test
    public void testWordCount(){
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("hello1.txt");
            Map<Character,Integer> map = new HashMap<>();
            int c = 0;
            while((c = fr.read()) != -1){
                //int 还原 char
                char ch = (char) c ;
                //判断char是否在map中第一次出现
                if(map.get(ch) == null){
                    map.put(ch,1); //第一次出现，所以value设置为1
                }else {
                    map.put(ch,map.get(ch) + 1); //在原有的value上 +1
                }
            }

            //3.吧map中的数据存放在wordCount.txt中
            //3.1创建Writer
            bw =new BufferedWriter(new FileWriter("wordCount.txt"));

            //3.2 遍历map，写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet){
                switch (entry.getKey()) {
                    case ' ' -> bw.write("空格=" + entry.getValue());
                    case '\t' -> bw.write("tab键=" + entry.getValue());
                    case '\r' -> bw.write("回车=" + entry.getValue());
                    case '\n' -> bw.write("换行=" + entry.getValue());
                    default -> bw.write(entry.getKey() + "=" + entry.getValue());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        

    }

}
