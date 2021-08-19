package service.OpenAPI.optional;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

/***
 * 更新分组名称管理
 */
public class Test3179  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3179";
    private static final  String bizcodeDesc = "更新分组名称管理";

    public static void main(String[] args) throws Exception {
        // 需要鉴权的接口 custNo 不为为空
        String custNo =  "1001881673";
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
        bodyJson.put("groupName", "新ss21");
        bodyJson.put("groupId", "87");

        return bodyJson;
    }
}
