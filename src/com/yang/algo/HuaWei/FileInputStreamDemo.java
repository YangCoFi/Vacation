package com.yang.algo.HuaWei;

/**
 * @ClassName FileInputStreamDemo
 * @Description TODO
 * @Author YangC
 * @Date 2019/8/1 16:59
 **/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception {

        /**
         * InputStream能从來源处读取一個一個byte,所以它是最低级的，
         */

        // read()方法返回的int类型，是表示数据下一个字节的字节码，如果已经到达流的最后面了，那就返回-1
        // 通过char 强转，输出字节码的内容
        FileInputStream fileIn2 = new FileInputStream(new File("hyy.txt"));
        int read = fileIn2.read();
        System.out.println( read);
        System.out.println((char) read);

        byte[] bb = new byte[4];
        int read2 = fileIn2.read(bb);
        System.out.println( "长度 read2： " + read2);
        for(byte b:bb) {
            System.out.println(b);
            System.out.println((char)b);
        }

        int aa;
        while ((aa = fileIn2.read()) != -1) {
            System.out.print((char) aa);
        }

        System.out.println();
        System.out.println("--------------------------------");

        /**
         * InputStreamReader封裝了InputStream在里头,它以较高级的方式,一次读取一个一个字符,
         *
         */

        FileInputStream fileIn3 = new FileInputStream(new File("C:\\MyProject\\Vacation\\src\\com\\yang\\algo\\HuaWei\\hyy.txt"));

        InputStreamReader sr = new InputStreamReader(fileIn3);
        System.out.println((char)sr.read());

        int a2;
        while ((a2 = sr.read()) != -1) {
            System.out.print((char) a2);
        }

        System.out.println();
        System.out.println("--------------------------------");

        /**
         * BufferedReader则是比InputStreamReader更高级,
         * 它封裝了StreamReader类,一次读取取一行的字符
         *
         */

        FileInputStream fileIn4 = new FileInputStream(new File("C:\\MyProject\\Vacation\\src\\com\\yang\\algo\\HuaWei\\hyy.txt"));
        InputStreamReader sr2 = new InputStreamReader(fileIn4);
        BufferedReader br=new BufferedReader(sr2);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }

}
