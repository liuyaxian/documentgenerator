package service.私募改版;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test5263查询最近的预约开放日 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5263";
    private static final  String bizcodeDesc = "查询最近的预约开放日";

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

        bodyJson.put("fundid","SQG330");

        return bodyJson;
    }
}
