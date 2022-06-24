package service.基金投顾;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2022/1/27 10:49
 * @history:
 */
public class Test3105查询交易结果页信息  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3105";
    private static final  String bizcodeDesc = "3105查询交易结果页信息";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883923";
        // 需要数据交易密码的接口
        String tradeacco = "1001546395";
        // 交易密码 111111
        String passwd = "111111";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("mctcustno", "1001883923");
        bodyJson.put("mainflag", "1");
        bodyJson.put("serialno", "202206241700373320100007");
        bodyJson.put("bizcode", "111");
        return bodyJson;
    }
}
