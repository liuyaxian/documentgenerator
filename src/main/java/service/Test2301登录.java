package service;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

/**
 * @desc:
 * @author: admin
 * @since: 2021/12/29 14:31
 * @history:
 */
public class Test2301登录  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2301";
    private static final  String bizcodeDesc = "2301登录";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883882";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "aaa111";
        JSONObject bodyJson =  setBody(bizcode, custNo, passwd);
        // 1001546198	1001883763
//        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);


        System.out.println(urlHttpReplaceHttps("http://pdf.dfcfw.com/pdf/H6_PNG30074106_1.png"));


    }

    public static  JSONObject setBody(String bizcode, String custNo, String passwd){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("sessionkey", "");
        bodyJson.put("devicetype", "iOS");
        bodyJson.put("idno", "13189749510");
        bodyJson.put("appkey", "7f2e8cbdd934e553");
        bodyJson.put("passwd", encryptPasswd(passwd));
        return bodyJson;
    }

    public static String urlHttpReplaceHttps(String url) {
        if (StringUtils.isNotBlank(url) && url.contains("http://")){
            return url.replace("http://", "https://");
        }
        return url;
    }
}


//
// {"msg":{"head":{"devicetype":"iOS","mctcode":"1000","version":"4.0","idfa":"00000000000000000000000000000000","sendtime":"102654","custip":"172.18.40.143",
//         "seqid":"1DAB44B84A1E495FBB623EEAD5F60642","appversion":"4.4.9","bizcode":"2301","deviceid":"400-678-8887","" +
//         "senddate":"20220105","zl-skip-cache":"1"},
//         "body":{"sessionkey":"","devicetype":"iOS","idno":"13189749510","appkey":"400-678-8887","passwd":"7f2e8cbdd934e553"}},"signtype":"m","sign":"b88326fe13d126ada2127db0b83711b1"}

