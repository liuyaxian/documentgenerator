package service.私募改版;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test5279单只基金收益统计 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5279";
    private static final  String bizcodeDesc = "单只基金收益统计";

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
        bodyJson.put("period", "RET_1M");
//        bodyJson.put("mctcustno", "1001883450");
//        bodyJson.put("tradeacco", "1001545788");

        return bodyJson;
    }
}

