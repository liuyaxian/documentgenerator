package service.渠道客户号获取失败;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test2307获取用户银行卡信息  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2307";
    private static final  String bizcodeDesc = "获取用户银行卡信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883935";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "aaa111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        String isAuth = "1";
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);

    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("mctcustno", "1001883935");
        bodyJson.put("tradeType", "ZL");
        bodyJson.put("orderbyfield", "opentime");

        return bodyJson;
    }
}
