package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author whh
 */
public class Test {

    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String path1 = "C:\\Users\\admin\\Desktop\\haveIp.txt";
        readFile01(path1);

        String path = "C:\\Users\\admin\\Desktop\\active301.txt";
        readFile02(path);
    }

    private static List<String> readFile02(String path) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
            String s = line.split("IP:")[1];
            String[] split = s.split("--->parameters");
            String ip = split[0];
            String de = split[1].split("deviceId=")[1];
            String deviceId = de.split("&wpi")[0];
            if (map.containsKey(deviceId)) {
                System.out.println("ip:" + ip + " deviceId:" + deviceId);
            }
        }
        br.close();
        isr.close();
        fis.close();
        return list;

    }

    private static void readFile01(String path) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
            map.put(line, line);
        }
        br.close();
        isr.close();
        fis.close();

    }

}
