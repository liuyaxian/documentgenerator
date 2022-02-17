package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/2/11 9:14
 * @history:
 */
public class Test3259投顾组合转出未满7天惩罚性赎回提示  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3259";
    private static final  String bizcodeDesc = "3259投顾组合转出未满7天惩罚性赎回提示";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883911";
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
        bodyJson.put("fundid", "C21001");
        bodyJson.put("tradeacco", "1001546367");

        return bodyJson;
    }
}
