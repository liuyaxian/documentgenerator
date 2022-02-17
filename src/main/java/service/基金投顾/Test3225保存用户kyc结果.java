package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/20 14:09
 * @history:
 */
public class Test3225保存用户kyc结果 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3225";
    private static final  String bizcodeDesc = "保存用户kyc结果";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883566";
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

        bodyJson.put("planHoldPeriod", 'C');
        bodyJson.put("investObject", 'C');
        bodyJson.put("investAmountProportion", 'C');
        bodyJson.put("question_id", 39);
        return bodyJson;
    }

}
