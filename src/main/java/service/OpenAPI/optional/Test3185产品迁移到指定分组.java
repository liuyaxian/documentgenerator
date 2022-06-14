package service.OpenAPI.optional;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/***
 * 3185 产品迁移到指定分组
 */
public class Test3185产品迁移到指定分组 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3185";
    private static final  String bizcodeDesc = "产品迁移到指定分组";

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


        bodyJson.put("removeFundIds", "260108");

        bodyJson.put("immigrateGroupIds", "857983,857949");


//        bodyJson.put("deleteGroupIds", "-1");

        return bodyJson;
    }
}
