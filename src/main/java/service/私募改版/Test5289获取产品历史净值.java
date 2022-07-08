package service.私募改版;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test5289获取产品历史净值 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5289";
    private static final  String bizcodeDesc = "获取产品历史净值";

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
        bodyJson.put("fundid", "SCW165");
        bodyJson.put("pagesize", "1");
        bodyJson.put("pageindex", "1");

        return bodyJson;
    }
}

