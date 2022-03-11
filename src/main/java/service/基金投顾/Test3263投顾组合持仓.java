package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/2/11 9:25
 * @history:
 */
public class Test3263投顾组合持仓  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3263";
    private static final  String bizcodeDesc = "3263投顾组合持仓";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空 1001883911
        String custNo =  "1001883548";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();

      //  bodyJson.put("rootTradeAcco", "1");

        return bodyJson;
    }
}
