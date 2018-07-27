package com.ceilan.Task;

import java.io.*;
import java.util.*;

public class ReadTxt {


    public static void main(String[] args) throws IOException {
      /*  // 节点流FileOutputStream直接以A.txt作为数据源操作
        FileOutputStream fileOutputStream = new FileOutputStream("C:/IO/aaa.txt");
        // 过滤流BufferedOutputStream进一步装饰节点流，提供缓冲写
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        // 过滤流DataOutputStream进一步装饰过滤流，使其提供基本数据类型的写
        DataOutputStream out = new DataOutputStream(bufferedOutputStream);
        out.writeInt(3);
        out.writeBoolean(true);
        out.flush();
        out.close();
        // 此处输入节点流，过滤流正好跟上边输出对应，读者可举一反三
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("A.txt")));
        System.out.println(in.readInt());
        System.out.println(in.readBoolean());
        in.close();*/
        try {
            //读取文件
            FileInputStream fis = new FileInputStream("C:/IO/aaa.txt");
            //fis.available():文件的长度
            byte[] b = new byte[fis.available()];
            //skip:跳过n个字节后再开始读取
//            fis.skip(5);//跳过前5个
            fis.read(b);
//            System.out.println(new String(b));
            String aaa=new String(b,"utf-8");
            String[] array=aaa.split(",");
            String[] array2;
            List list=new LinkedList();
            Map map=new LinkedHashMap();
            for (String inval:array){
                map=new LinkedHashMap();
                array2=inval.split(":");
                String id=array2[0].replaceAll("[\\']","");
                String name=array2[2].replaceAll("[\\']","");
                map.put("id",id);
                map.put("name",name);
                if(id.length()<3){
                    map.put("type",1);
                }else if(id.length()>2&&id.length()<5){
                    map.put("type",2);
                }else{
                    map.put("type",3);
                }
                list.add(map);
            }
            System.out.println(map.toString());
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}