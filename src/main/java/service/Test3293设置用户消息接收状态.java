package service;

import net.sf.json.JSONObject;

public class Test3293设置用户消息接收状态  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3293";
    private static final  String bizcodeDesc = "设置用户消息接收状态";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883881";
        // 需要数据交易密码的接口
        String tradeacco = "1001544496";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("notifyType", "SEW390");
        bodyJson.put("receptionStatus", "Y");

        return bodyJson;
    }
}
