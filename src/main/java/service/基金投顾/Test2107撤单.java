package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/27 13:37
 * @history:
 */
public class Test2107撤单  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2107";
    private static final  String bizcodeDesc = "2107撤单";

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

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("mctcustno", "1001883516");
        bodyJson.put("mainflag", "1");
        bodyJson.put("serialno", "202202091836451299100007");
        bodyJson.put("bizcode", "3255");
        return bodyJson;
    }
}

