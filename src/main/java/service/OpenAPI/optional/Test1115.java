package service.OpenAPI.optional;

import net.sf.json.JSONObject;
import service.DocumentGeneratorServiceImpl;

import java.io.IOException;

public class Test1115 extends DocumentGeneratorServiceImpl {

    private static final  String bizcode = "1115";
    private static final  String bizcodeDesc = "自选功能";

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

        bodyJson.put("operatetype","0");
        bodyJson.put("expand","1");


        bodyJson.put("mctcustno","1001881673");
        bodyJson.put("operatetype","0");
        bodyJson.put("expand","1");

        bodyJson.put("mctcustno","1001883308");
        bodyJson.put("operatetype","1");
        bodyJson.put("expand","0");
        bodyJson.put("fundid","XZG100");



        return bodyJson;
    }
}
