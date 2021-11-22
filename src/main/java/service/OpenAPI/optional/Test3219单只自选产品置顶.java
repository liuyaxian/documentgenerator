package service.OpenAPI.optional;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/**
 * @desc:
 * @author: admin
 * @since: 2021/11/4 14:53
 * @history:
 */
public class Test3219单只自选产品置顶 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3219";
    private static final  String bizcodeDesc = "3219单只自选产品置顶";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001883516";
        // 需要数据交易密码的接口
        String tradeacco = "";
        // 交易密码 111111
        String passwd = "";
        JSONObject bodyJson =  setBody(bizcode, custNo);
        // 1001546198	1001883763
        requestUrl(custNo, tradeacco, passwd, bizcode, bizcodeDesc, bodyJson);
    }

    public static JSONObject setBody(String bizcode, String custNo){
        JSONObject bodyJson = new JSONObject();
        bodyJson.put("groupId", 857949);
        bodyJson.put("fundid", "003096");
        return bodyJson;
    }
}
