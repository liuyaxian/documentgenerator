package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/3/1 10:40
 * @history:
 */
public class Test3279投顾服务费明细  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3279";
    private static final  String bizcodeDesc = "3279投顾服务费明细";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883548";
        // 需要数据交易密码的接口
        String tradeacco = "1001546383";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("tradeacco","1001546383");
        bodyJson.put("fundid","C21001");

        return bodyJson;
    }
}
