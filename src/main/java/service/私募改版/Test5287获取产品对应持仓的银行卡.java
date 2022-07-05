package service.私募改版;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test5287获取产品对应持仓的银行卡 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5287";
    private static final  String bizcodeDesc = "获取产品对应持仓的银行卡";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空 1001883450 1001883516
        String custNo =  "1001883450";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        String isAuth = "1";
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("fundid", "000771");
        bodyJson.put("pagesize", "1");
        bodyJson.put("pageindex", "4");

        return bodyJson;
    }
}

