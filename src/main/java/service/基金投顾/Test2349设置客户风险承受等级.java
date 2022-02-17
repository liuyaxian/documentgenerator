package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/2/9 16:34
 * @history:
 */
public class Test2349设置客户风险承受等级 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "2349";
    private static final  String bizcodeDesc = "设置客户风险承受等级";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883308";
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
        bodyJson.put("fundtype", "2");
        bodyJson.put("mctcustno", "1001883308");
        bodyJson.put("question", "1");
        bodyJson.put("answer", "CCCCCCA");
        bodyJson.put("ipaddr", "100.66.173.17");
        return bodyJson;
    }

}