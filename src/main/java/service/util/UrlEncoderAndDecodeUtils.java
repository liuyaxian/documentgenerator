package service.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncoderAndDecodeUtils {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "%7B%22bizCode%22%3A%222169%22%2C%22msg%22%3A%7B%22auth%22%3A%7B%22authcode%22%3A%22a70a44cd76b81cb1e7092491b1e6f2b5%22%2C%22authtype%22%3A%220%22%2C%22idno%22%3A%22510722199108188496%22%2C%22mctcustno%22%3A%22510722199108188496%22%2C%22tradeacco%22%3A%221001107378%22%7D%2C%22body%22%3A%7B%22bankKey%22%3A%22c10%22%2C%22isidno15%22%3A%220%22%2C%22mobileno%22%3A%2218681629981%22%2C%22tradeacco%22%3A%221001107378%22%7D%2C%22head%22%3A%7B%22bizcode%22%3A%222169%22%2C%22custip%22%3A%22121.69.128.146%22%2C%22mctcode%22%3A%220031%22%2C%22senddate%22%3A%2220220721%22%2C%22sendtime%22%3A%22102951%22%2C%22seqid%22%3A%227a97f400ebbc4339a02d3f345e61aa46%22%2C%22version%22%3A%221.0%22%7D%7D%2C%22sign%22%3A%222110851f25440048add63df195a52a0d%22%2C%22signtype%22%3A%22m%22%7D";
        urlDecode(str);
    }

    public static void urlDecode(String str) throws UnsupportedEncodingException {

        System.out.printf("编码： %s", URLEncoder.encode(str, "utf-8"));
        System.out.println("\n\n");
        System.out.printf("解码： %s", URLDecoder.decode(str, "utf-8"));
    }
}
