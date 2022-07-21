package service.渠道客户号获取失败;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test2411基金转换036955956  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2411";
    private static final  String bizcodeDesc = "基金转换036955956";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883935";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        String isAuth = "1";
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("fundid", "110022");
        bodyJson.put("ofundid", "161725");
        bodyJson.put("subquty", 100);
        bodyJson.put("transfertp", "1");
        bodyJson.put("agreerisk", "1");
        bodyJson.put("agreement", "《协议一》，《协议二》");
        bodyJson.put("largeredeemflag", "0");


        return bodyJson;
    }
}
