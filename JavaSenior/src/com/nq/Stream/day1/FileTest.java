package com.nq.Stream.day1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *     并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”。(从哪读，写到哪)
 *
 *
 * @Author Nq
 * @Data 2021-02-24-21:52
 */
public class FileTest {
    /*
    1.如何创建File类的实例
    四种构造器：
        File(String pathname)
        File(String parent,String child)
        File(File parent,String child)
        File(URI uri)

     2.
      相对路径：相较于某个路径下，指明的路径。
      绝对路径：包含盘符在内的文件或文件目录的路径

     3.路径分隔符
       windows: \\
       unix: /

     */
    @Test
    public void test1(){
        //构造器1 File(String pathname)
        File file = new File("hello.txt"); //相对于当前module
        File file1 = new File("E:\\IDEA workspace\\shangxuetang\\JavaSenior\\com\\nq\\month2\\day24\\hello.txt");

        //构造器2 File(String parent,String child)
        File file2 = new File( "E:\\IDEA workspace\\shangxuetang","JavaSenior");
        System.out.println(file2);

        //构造器3 File(File parent,String child)
        File file3 = new File(file2,"hi.txt");
        System.out.println(file3);
    }

    /*
public String getAbsolutePath():获取绝对路径
public String getPath(): 获取路径
public String getName(): 获取名称
public String getParent(): 获取上层文件目录路径。若无，返回null
public Long length(): 获取文件长度(字节数),不能获取目录长度
public Long lastModified(): 获取最后一次的修改时间，毫秒值
如下的两个方法适用于文件目录：
public String[] list(): 获取指定目录下的所有文件或者文件目录的名称数组
public File[] listFiles(): 获取指定目录下的所有文件或者文件目录的File数组
     */

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\IDEA workspace\\shangxuetang\\JavaSenior\\hello2.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3(){
        File file = new File("E:\\IDEA workspace\\shangxuetang\\JavaSenior\\src\\com\\nq");
        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }

    }

    /*
    public boolean renameTo(File dest):吧文件重命名为指定的文件路径
     比如：file1.renameTo(file2)
        要想保住返回true，需要file1存在于硬盘中，且file2不存在于硬盘
     */
    @Test
    public void test4(){
        File file1 = new File("hello2.txt");
        File file12 = new File("E:\\IDEA workspace\\shangxuetang\\JavaSenior\\hello.txt");

        boolean renameTo = file1.renameTo(file12);
        System.out.println(renameTo);
    }

    /*
public boolean isDirectory():判断是否是文件目录
public boolean isFile():判断是否是文件   与isDirectory()方法一般二选一，因为不是文件目录就是文件
public boolean exists():判断是否存在 (是否在硬盘中)
public boolean canRead():判断是否可读
public boolean canWrite():判断是否可写
public boolean isHidden():判断是否隐藏

     */
    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("E:\\\\IDEA workspace\\\\shangxuetang\\\\JavaSenior");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }
    /*
    创建硬盘中的文件或文件目录
public boolean createNewFile(): 创建文件。若文件存在，则不创建，返回false
public boolean mkidir(): 创建文件目录。如果文件目录存在，就不创建，如果上层文件目录不存在,并不会创建
public boolean mkdirs(): 创建文件目录，如果上层文件目录不存在，一并创建了
    删除硬盘中的文件或文件目录
public boolean delete():删除文件或文件夹
    删除注意事项：
    Java中的删除不走回收站
    */
    @Test
    public void test6() throws IOException {
        File file1 = new File("hello2.txt");
        if(!file1.exists()){ //若不存在
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else { //存在时
            file1.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test7(){
        File file1 = new File("E:\\\\IDEA workspace\\\\shangxuetang\\\\Java5123");
        File file2 = new File("E:\\\\IDEA workspace\\\\shangxuetang\\\\Java5123");
        boolean mkdir = file1.mkdir();
        if (mkdir){
            System.out.println(" 创建成功");
        }else file1.delete();
    }


}
