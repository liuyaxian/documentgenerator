package service.私募改版;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test5259根据月份获取产品的交易日历信息 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5259";
    private static final  String bizcodeDesc = "据月份获取产品的交易日历信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883551";
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

        bodyJson.put("fundid","SCW165");
        bodyJson.put("datetime","20220109");



        return bodyJson;
    }
}

