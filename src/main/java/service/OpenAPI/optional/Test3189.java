package service.OpenAPI.optional;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;

/**8
 * 3189 添加自选基金
 */
public class Test3189  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3189";
    private static final  String bizcodeDesc = "添加自选基金";

    public static void main(String[] args) throws IOException, Exception {
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
        String str = "[{'fundId':'161826'}]";
        JSONArray jsonArray = JSONArray.fromObject(str);
        JSONArray.toList(jsonArray, new CustOptionalFund(),  new JsonConfig());

//        List<Object> list = new ArrayList<>();
//        list.add(JSON.toJSON(jsonArray));
//        bodyJson.put("custOptionalGroup", list);
        bodyJson.put("custOptionalFund", JSONArray.toList(jsonArray, new CustOptionalFund(),  new JsonConfig()));
        bodyJson.put("groupIds", "-1");
        return bodyJson;
    }
}
