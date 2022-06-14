package service.安心签;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test3165获取协议书客户信息     extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3165";
    private static final  String bizcodeDesc = "3165获取协议书客户信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        return bodyJson;
    }
}
