package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/26 16:58
 * @history:
 */
public class Test3247投顾组合转入  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3247";
    private static final  String bizcodeDesc = "投顾组合转入";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883911";
        // 需要数据交易密码的接口
        String tradeacco = "1001546330";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("serviceid", "C21001");
        bodyJson.put("subamt", 1000);
        bodyJson.put("paymenttp", "0");
        bodyJson.put("bankcmd", "1");
        bodyJson.put("postponeflag", "1");
        bodyJson.put("agreerisk", "1");
        bodyJson.put("bidtp", "1");
        return bodyJson;
    }
}
