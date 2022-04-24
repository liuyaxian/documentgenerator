package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test2339用户支付方式  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2339";
    private static final  String bizcodeDesc = "2339用户支付方式";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("mctcustno", "1001883516");

        bodyJson.put("fundid", "000771");

        return bodyJson;
    }
}
