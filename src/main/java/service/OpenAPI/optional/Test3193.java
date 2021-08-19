package service.OpenAPI.optional;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;

/***
 * 3193 将持仓基金导入自选基金
 */
public class Test3193  extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "3193";
    private static final  String bizcodeDesc = "将持仓基金导入自选基金";

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

        return bodyJson;
    }
}
