package service.客户信息相关接口;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/13 10:39
 * @history:
 */
public class Test5253购买私募前置校验 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "5253";
    private static final  String bizcodeDesc = "购买私募前置校验";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "1001546209";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static  JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("agreerisk", "1");
        bodyJson.put("subamt", "12655094");
        bodyJson.put("paymenttp", "1");
        bodyJson.put("agreecontract", "1");
        bodyJson.put("serviceid", "SEW390");
        bodyJson.put("tradeacco", "1001546238");

        return bodyJson;
    }
}
