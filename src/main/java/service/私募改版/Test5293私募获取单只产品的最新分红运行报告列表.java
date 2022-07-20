package service.私募改版;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test5293私募获取单只产品的最新分红运行报告列表  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5293";
    private static final  String bizcodeDesc = "私募获取单只产品的最新分红运行报告列表";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空 1001883450 1001883516
        String custNo =  "1001883450";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        String isAuth = "";
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("fundid", "SCW165");
        return bodyJson;
    }
}
