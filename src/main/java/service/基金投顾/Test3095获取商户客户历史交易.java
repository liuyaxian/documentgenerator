package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/2/16 14:26
 * @history:
 */
public class Test3095获取商户客户历史交易  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3095";
    private static final  String bizcodeDesc = "3095获取商户客户历史交易";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001881527";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        String isAuth = "1";
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson, isAuth);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("mctcustno", "1001882171");
        bodyJson.put("mainflag", "1");
        bodyJson.put("tradetype", "zlpay");

        return bodyJson;
    }
}
