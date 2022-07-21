package service.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class UTF8encoderUtils {


    public static void main(String[] args) {
        //  //默认环境，已是UTF-8编码
        String str = "测试字符转换 hello word";
        try {
            String strGBK = URLEncoder.encode(str, "GBK");
            System.out.println(strGBK);

            String strUTF8 = URLDecoder.decode(str, "UTF-8");
            System.out.println(strUTF8);

            String str2 = URLEncoder.encode("中国","utf-8");  //转码
            System.out.println(str2);

            String str3=URLDecoder.decode(str2, "UTF-8"); //解码
            System.out.println(str3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
