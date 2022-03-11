package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/3/11 9:48
 * @history:
 */
public class Test3113获取现金宝组合支付关联交易结果页信息  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3113";
    private static final  String bizcodeDesc = "3113获取现金宝组合支付关联交易结果页信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "1001544763";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("serialno", "202203081523403100202171");
        return bodyJson;
    }
}
