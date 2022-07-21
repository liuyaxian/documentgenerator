package service.客户信息相关接口;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

public class Test3019客户app消息列表 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3019";
    private static final  String bizcodeDesc = "3019客户app消息列表";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883674";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "aaa111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);

    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("mctcustno", "1001883674");
        return bodyJson;
    }
}
