package service.渠道客户号获取失败;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test2409获取基金转换的交易类型与确认信息  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2409";
    private static final  String bizcodeDesc = "获取基金转换的交易类型与确认信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883935";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        String isAuth = "1";
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("fundid", "530014");
        bodyJson.put("subquty", 1);
        bodyJson.put("ofundid", "003009");
        bodyJson.put("availablebal", 1.2);

        return bodyJson;
    }
}

