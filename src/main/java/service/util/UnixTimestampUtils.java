package service.util;

import java.util.Date;

public class UnixTimestampUtils {


    // 现在unix 时间戳 unix timestamp
    public static void getCurrentUnixTimestamp(){
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()/1000);
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        System.out.println(date);

    }

    // Unix时间戳（Unix timestamp）  转化格式  2022-07-21 14:54:29
     public static void get(){

     }


    public static void main(String[] args) {
        getCurrentUnixTimestamp();
    }

}


